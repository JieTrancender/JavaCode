package org.jason.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/2/28.
 */

/**
 * 模拟GenericServlet
 * @author Jason
 */

@WebServlet(name = "/SecondServlet")
public class SecondServlet implements Servlet {
    private ServletConfig config;

    /**
     * 由Tomcat来调用，并且只调用一次
     * 他是这些方法中第一个被调用的，在构造器之后马上被调用
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    public void init() {
        System.out.println("init...");
    }

    /**
     * 该方法一定会在init方法之后调用
     * init方法调用之后config已经有值了
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("每次处理请求都会被调用");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    public ServletContext getServletContext() {
        return config.getServletContext();
    }

    public String getServletName() {
        return config.getServletName();
    }

    public String getInitParameter(String name) {
        return config.getInitParameter(name);
    }
}
