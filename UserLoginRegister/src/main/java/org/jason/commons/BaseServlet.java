package org.jason.commons;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by JTrancender on 2017/3/15.
 */
public abstract class BaseServlet extends HttpServlet {
    /**
     * 1. 获取参数，用来识别用户想请求的方法
     * 2. 得到方法名称，通过方法名再得到Method类的对象
     *   需要得到Class，然后调用它的方法进行查询，得到Method
     *   我们要查询的是当前类的方法，所以我们需要得到当前类的Class
     * 3. 调用method表示的方法
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        if (methodName == null || methodName.trim().isEmpty()) {
            throw new RuntimeException("你没有传递method参数,无法确定你要调用的方法");
        }
        Class c = this.getClass();
        Method method = null;
        try {
            method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("你要调用的方法:" + methodName + "，不存在！");
        }

        try {
            String result = (String) method.invoke(this, req, resp);
            /**
             * 获取请求处理方法执行后返回的字符串，他表示转发或者重定向的路径
             *   查看返回的字符串,没有冒号就默认为转发，有就是用冒号分割字符串，得发哦前缀和后缀，f表示转发，r表示重定向；后缀就是路径
             */
            if (result == null || result.trim().isEmpty()) {
                return;
            }
            if (result.contains(":")) {
                int index = result.indexOf(":");
                String prev = result.substring(0, index);
                String path = result.substring(index + 1, result.length());

                if (prev.equalsIgnoreCase("r")) {
                    resp.sendRedirect(req.getContextPath() + path);
                } else if (prev.equalsIgnoreCase("f")) {
                    req.getRequestDispatcher(path).forward(req, resp);
                } else {
                    throw new RuntimeException("你指定的操作:" + methodName + ",目前还不支持");
                }
            } else {
                req.getRequestDispatcher(result).forward(req, resp);
            }

        } catch (Exception e) {
            System.out.println("你调用的方法:" + methodName + ",内部出现了异常");
            throw new RuntimeException(e);
        }
    }
}
