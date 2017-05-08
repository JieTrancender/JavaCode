package org.jason.user.web.listener; /**
 * Created by JTrancender on 2017/5/9.
 */

import org.jason.commons.CommonUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;

@WebListener()
public class SessionCounterListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private static int activeSessions = 0;
    private HttpServletRequest request;
    private static ArrayList<String> arrayList = new ArrayList<String>();

    // Public constructor is required by servlet spec
    public SessionCounterListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        request = (HttpServletRequest) servletRequestEvent.getServletRequest();
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
      String ip = CommonUtils.getIpAddr(request);
      boolean flag = false;
      for (String ipAddr : arrayList) {
          if (ipAddr.equalsIgnoreCase(ip)) {
              flag = true;
              break;
          }
      }
      if (!flag) {
          arrayList.add(ip);
          ++activeSessions;
      }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
      String ip = CommonUtils.getIpAddr(request);
        if (activeSessions > 0) {
            for (String ipAddr : arrayList) {
                if (ipAddr.equalsIgnoreCase(ip)) {
                    arrayList.remove(ipAddr);
                }
            }
            --activeSessions;
        }
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}
