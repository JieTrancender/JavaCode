package org.jason.user.web.listener; /**
 * Created by JTrancender on 2017/5/9.
 */

import org.jason.commons.CommonUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;

@WebListener()
public class SessionCounterListener implements ServletRequestListener, HttpSessionListener {
    private static int activeSessions = 0;
    private HttpServletRequest request;
    private static ArrayList<String> arrayList = new ArrayList<String>();

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        request = (HttpServletRequest) servletRequestEvent.getServletRequest();
    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        String ipAddr = CommonUtils.getIpAddr(request);
        boolean flag = false;

        for (String ip : arrayList) {
            if (ip.equalsIgnoreCase(ipAddr)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            arrayList.add(ipAddr);
            ++activeSessions;
        }
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        String ipAddr = CommonUtils.getIpAddr(request);
        if (activeSessions > 0) {
            for(String ip : arrayList) {
                if (ip.equalsIgnoreCase(ipAddr)) {
                    arrayList.remove(ipAddr);
                }
            }
            --activeSessions;
        }
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}
