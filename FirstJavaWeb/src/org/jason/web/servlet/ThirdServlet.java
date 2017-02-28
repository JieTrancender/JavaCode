package org.jason.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Created by JTrancender on 2017/2/28.
 */

@WebServlet(name = "/ThridServlet")
public class ThirdServlet extends SecondServlet {
    @Override
    public void init() {
        System.out.println("SecondServlet#init...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException{
        String value = getInitParameter("p1");
    }
}
