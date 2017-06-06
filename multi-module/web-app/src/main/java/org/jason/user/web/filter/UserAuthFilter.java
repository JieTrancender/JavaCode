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
import java.util.HashMap;
import java.util.Map;

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

        User user = (User) request.getSession().getAttribute("current");
        if (user == null) {
            String queryString = request.getQueryString();
            Map<String, String> paramMap = new HashMap<String, String>(3);
            if (queryString != null) {
                String[] paramPairs = queryString.split("&");
                for (String paramPair : paramPairs) {
                    String[] pair = paramPair.split("=", 2);
                    if (pair.length ==  2) {
                        paramMap.put(pair[0], pair[1]);
                    }
                }
            }
            String userType = paramMap.get("userType");
            if (userType != null && userType.equalsIgnoreCase("RegisteredUser")) {
                String userIdDigest = paramMap.get("userIdDigest");
                String rememberMeDigest = paramMap.get("rememberMeDigest");
                if (userIdDigest != null && rememberMeDigest != null) {
                    UserService userService = new UserService();
                    try {
//                        user = userService.cookieLogin(userIdDigest, rememberMeDigest);
                        user = userService.readUserAuth(userIdDigest, rememberMeDigest);
                        HttpSession httpSession = request.getSession();
                        httpSession.setAttribute("current", user);
                        CommonUtils.addCookie(response, "userIdDigest", userIdDigest);
                        CommonUtils.addCookie(response, "rememberMeDigest", rememberMeDigest);
                    } catch (UserException e) {
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
