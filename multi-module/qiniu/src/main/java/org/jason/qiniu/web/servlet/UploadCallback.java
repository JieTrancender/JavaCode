package org.jason.qiniu.web.servlet;

import java.io.IOException;
import java.util.Map;

/**
 * Created by JTrancender on 2017/4/18.
 */
@javax.servlet.annotation.WebServlet(name = "UploadCallback")
public class UploadCallback extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Map callbackMap = request.getParameterMap();

        for (Object key : callbackMap.keySet()) {
            System.out.println(key + "=" + callbackMap.get(key));
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Map callbackMap = request.getParameterMap();

        for (Object key : callbackMap.keySet()) {
            System.out.println(key + "=" + callbackMap.get(key));
        }
    }
}
