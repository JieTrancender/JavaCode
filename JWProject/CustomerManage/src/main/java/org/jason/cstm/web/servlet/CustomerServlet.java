package org.jason.cstm.web.servlet;

import java.io.IOException;
import org.jason.commons.BaseServlet;
import org.jason.cstm.service.CustomerService;

/**
 * Created by JTrancender on 2017/3/16.
 */
@javax.servlet.annotation.WebServlet(name = "CustomerServlet")
public class CustomerServlet extends BaseServlet {
    private CustomerService customerService = new CustomerService();
}
