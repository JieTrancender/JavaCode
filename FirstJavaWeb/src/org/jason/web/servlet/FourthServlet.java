package org.jason.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/2/28.
 */

@WebServlet(name = "/FourthServlet")
public class FourthServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello World");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("FourthServlet#init...");
    }

    @Override
    public void destroy() {
        System.out.println("FourthServlet#destroy...");
    }
}
