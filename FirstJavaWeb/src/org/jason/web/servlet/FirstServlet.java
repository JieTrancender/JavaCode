package org.jason.web.servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by JTrancender on 2017/2/28.
 */

@WebServlet(name = "/FirstServlet")
public class FirstServlet implements Servlet {
    /**
     * 生命周期方法
     * 在Servlet被销毁之前调用，并只会被调用一次
     */
    @Override
    public void destroy() {
        System.out.println("destory...");
    }

    /**
     * 生命周期方法
     * 在Servlet对象创建之后立马执行，并只执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");

        /**
         *获取初始化参数
         */
        System.out.println(servletConfig.getInitParameter("p1"));
        System.out.println(servletConfig.getInitParameter("p2"));

        /**
         * 获取所有初始化参数的名称
         */
        Enumeration e = servletConfig.getInitParameterNames();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }

    /**
     * 可以用来获取Servlet的配置信息
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig...");
        return null;
    }

    /**
     * 生命周期方法
     * 它会被调用多次
     * 每次处理请求都是在调用这个方法
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("destoservicery...");
    }

    /**
     * 获取Servlet的信息
     * @return
     */
    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo...");
        return null;
    }
}
