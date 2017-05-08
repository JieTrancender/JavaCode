package org.jason.user.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/5/9.
 */
@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    private  static String encodingDefault = "utf-8";
    private String encoding = null;
    private FilterConfig filterConfig;

    public void destroy() {
        encoding = null;
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encoding = this.encoding;
        if (encoding == null) {
            encoding = encodingDefault;
        }
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request,  response);
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
        this.encoding = filterConfig.getInitParameter("encoding");
    }

}
