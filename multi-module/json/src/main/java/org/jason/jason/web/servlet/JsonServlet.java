package org.jason.jason.web.servlet;

import org.jason.commons.CommonUtils;
import org.jason.user.domain.UserAuth;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by JTrancender on 2017/5/16.
 */
@WebServlet(name = "JsonServlet")
public class JsonServlet extends HttpServlet {
    private static final long serialVersionUId = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        System.out.println("JsonServlet#doPost");

        System.out.println(request.getQueryString());
        System.out.println(request.getRequestURI());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        System.out.println(request.getQueryString());
        System.out.println(request.getRequestURI());

        Map map = request.getParameterMap();
        for (Object key : map.keySet()) {
            String[] values = (String[]) map.get(key);
            for (String value : values) {
                System.out.println(key + "=" + value);
            }
        }

        UserAuth userAuth = new UserAuth("983B0A664C5C4071B0C3E2559168905B", "QQ", "582865471", "JTrancender...", CommonUtils.getRememberMeDigest());
        JSONObject jsonObject = new JSONObject(userAuth);

        String callbackName = request.getParameter("jsoncallback");
        String renderStr = callbackName + "(" + jsonObject.toString() + ")";

        System.out.println(renderStr);

        PrintWriter printWriter = response.getWriter();
        printWriter.write(renderStr);

        printWriter.close();
    }
}
