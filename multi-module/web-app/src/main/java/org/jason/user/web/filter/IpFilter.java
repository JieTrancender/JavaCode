package org.jason.user.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.jason.commons.CommonUtils.getIpAddr;

/**
 * Created by JTrancender on 2017/5/9.
 */
@WebFilter(filterName = "IpFilter")
public class IpFilter implements Filter {
    private FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        ServletContext servletContext = filterConfig.getServletContext();
        Map<String, Integer> ipContextMap = (Map<String, Integer>) servletContext.getAttribute("ipContextMap");
        if (null ==  ipContextMap) {
            ipContextMap = new LinkedHashMap<String, Integer>();
        }
        Integer sessionSum = (Integer) servletContext.getAttribute("sessionSum");
        if (null == sessionSum) {
            sessionSum = new Integer(0);
        }

        HttpSession httpSession = request.getSession();
        Map<String, Integer> ipSessionMap = (Map<String, Integer>) httpSession.getAttribute("ipSessionMap");
        if (null == ipSessionMap) {
            ipSessionMap = new LinkedHashMap<String, Integer>();
        }

        String ip = getIpAddr(request);
        if (ipContextMap.containsKey(ip)) {
            Integer count = ipContextMap.get(ip);
            if (!ipSessionMap.containsKey(ip)) {
                ipSessionMap.put(ip, 1);
                ipContextMap.put(ip, ++count);
                ++sessionSum;
            }
        } else {
            ipContextMap.put(ip, 1);
            ipSessionMap.put(ip, 1);
            ++sessionSum;
        }
        servletContext.setAttribute("ipContextMap", ipContextMap);
        servletContext.setAttribute("sessionSum", sessionSum);
        httpSession.setAttribute("ipSessionMap", ipSessionMap);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }
}
