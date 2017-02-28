package org.jason.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * 使用ServletContext获取资源路径
 * Created by JTrancender on 2017/2/28.
 */
@WebServlet(name = "/DServlet")
public class DServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 它得到的是有盘符的路径:F:/xxx/xxx/xx
         */
        String path = this.getServletContext().getRealPath("/index.jsp");
        System.out.println(path);

        /**
         * 获取资源的路径后，在创建输入流对象
         */
        InputStream input = this.getServletContext().getResourceAsStream("/index.jsp");

        /**
         * 获取当前路径下所有资源的路径
         */
        Set<String> paths = this.getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(paths);
    }
}
