package org.jason.user.web.filter;

import org.jason.commons.CommonUtils;
import org.jason.user.domain.User;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/5/9.
 */
@WebFilter(filterName = "UserAuthFilter")
public class UserAuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println("UserAuthFilter#...");
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

//        String userType1 = request.getParameter("userType");
//        String userIdDigest1 = request.getParameter("userIdDigest");
//        String rememberMeDigest1 = request.getParameter("rememberMeDigest");
//        System.out.println("Filter#" + userType1 + " " + userIdDigest1 + " " + rememberMeDigest1);
//        S
        String queryString = request.getQueryString();
        if (queryString != null) {
            System.out.println(queryString);
            System.out.println(queryString.substring(0));
        }


        User user = (User) request.getSession().getAttribute("current");
        if (user == null) {
            String userType = request.getParameter("userType");
            if (userType != null && userType.equalsIgnoreCase("RegisteredUser")) {
                String userIdDigest = (String) request.getParameter("userIdDigest");
                String rememberMeDigest = (String) request.getParameter("rememberMeDigest");
                if (userIdDigest != null && rememberMeDigest != null) {
                    UserService userService = new UserService();
                    try {
                        user = userService.cookieLogin(userIdDigest, rememberMeDigest);
                        HttpSession httpSession = request.getSession();
                        httpSession.setAttribute("current", user);
                        CommonUtils.addCookie(response, "userIdDigest", userIdDigest);
                        CommonUtils.addCookie(response, "rememberMeDigest", rememberMeDigest);
                        System.out.println("before UserAuthFilter:" + user.toString());
                    } catch (UserException e) {
//                        e.printStackTrace();
//                        return;
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
