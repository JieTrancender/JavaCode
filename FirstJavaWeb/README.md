##### Interface Enumeration&lt;E&gt;

> java.util

1. **boolean hasMoreElements()** - 判断是否还有更多的元素
2. **E nextElement()** - 当有至少一个元素的时候返回一个元素

##### Interface ServletConfig

> javax.servlet

1. **Enumeration getInitParameterName()** - 获取Servlet初始化文件中的param-name
2. **String getInitParameter(String paramName)** - 根据初始化文件的param-name获取param-value
3. **String getServletName()** - 获取Servlet实例名称
4. **ServletContext getServletContext()** - 获取Servlet环境的引用

##### Interface Servlet

> javax.servlet
> init方法将会第一个被调用并且只会被调用一次，是生命周期方法
> destroy方法将会在Servlet被销毁之前调用并且只会被调用一次，是生命周期方法
> service方法在每次处理请求的时候都会被调用，是生命周期方法

1. **void init(ServletConfig servletConfig)** - Servlet容器根据配置文件信息指向特定的Servlet
2. **void service(ServletRequest servletRequest, ServletResponse servletResponse)** - Servlet容器允许servlet对request做出response
3. **void destroy()** - Servlet容器指定一个Servlet退出服务
4. **ServletConfig getServletConfig()** - 获取Servlet的配置信息
5. **String getServletInfo()** - 获取关于Servlet的有关信息，author。。。

> 派生类重写父类方法时可能导致父类方法代码丢失

        public class BaseClass {
          private ServletConfig config;
          public init(ServletConfig servletConfig) {
            this.config = servletConfig;
          }
        } 

        public class SubClass extends BaseClass {
          public init(ServletConfig servletConfig) {
            ...
          }
        }

> 利用重载方案解决这个问题

        public class BaseClass {
          private ServletConfig config;
          public init(ServletConfig servletConfig) {
            this.config = servletConfig;
            init();
          }

          public init() {
            ...
          }
        }

        public class SubClass extends BaseClass {
          public init() {
            ...
          }
        }

##### Class GenericServlet

> public abstract class GenericServlet extends Object implements Servlet, ServletConfig, Serialiable
> private ServletConfig config

1. **void init(ServletConfig servletConfig)** - Servlet容器调用用来指定一个Servlet用于提供服务
2. **void init()** - 用于派生类重载(不用调用基类的**super.init(config)**)
3. **String getInitParameter(String name)** - 根据配置文件中的`param-name`获取``param-value`
4. **Enumeration getInitParameterNames()** - 获取配置文件中的所有`param-name`
5. **String getServletName

        //配置文件中
        <init-param>
          <param-name>@Author</param-name>
          <param-value>Jason</param-value>
        </init-param>

        //Servlet文件中
        Enumeration e = getInitParameterNames();
        while (e.hasMoreElemetns()) {
          String paramName = (String)e.nextElement();
          System.out.println(paramName + ": " + getInitParameter(paramName));
        }

6. **ServletContext getServletContext()** - 获取一个ServletContext的引用

    > ServletContext对象在Web应用程序装载时初始化，会与每一个ServletContext对象关联

        //配置文件中
        <context-param>
          <param-name>@Admin</param-name>
          <param-value>JTrancender</param-value>
        </context-param>

7. **ServletConfig getServletConfig()** - 获取该Servlet的ServletConfig对象
8. **String getServletInfo()** - 获取Servlet的信息
9. **String getServletName()** - 获取Servlet的名称
10. **void log(String msg)** - 写msg到Servlet log文件
11. **void log(String msg, Throwable t)** - 写msg和栈回溯到log文件
12. **abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)** - Servlet容器调用用来允许servlet对请求做出回应
13. **void destroy()** - Servlet容器指定servlet退出服务

##### Class HttpServlet

> public abstract class HttpServlet extends GenericServlet implements Sericalizable

1. **protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)** - server允许servlet处理一个Get request
2. **protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)** - server允许servlet处理一个Post request

> 类似地方法还有 **doDelete**、**doPut**、**doTrace**、**doOptions**

3. **protected void doHead(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)** - 从service收到HTTP头请求并且处理这个请求
4. **protected long getLastModified(HttpServletRequest httpServletRequest)** - 获取该对象的最后修改时间，1970-1-1到现在的毫秒数
5. **protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)** - 收到标准HTTP请求并且分派他们到doXXX方法
6. **void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)** - 分派client请求到service方法

##### HTTP使用

1. 重定向
    
    > 1. 设置Location
    > 2. 发送302状态码

        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          response.setHeader("Location", "/LocationHttpServlet");
          response.setStatus(302);

          //快速重定向方法
          response.sendRedirect("/LocationHttpServlet");
        }

2. Refresh响应头

    > 1. 发送响应体
    > 2. 设置Refresh的响应头
    
        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          PrintWriter printWriter = response.getWriter();
          printWriter.print("欢迎登录，4秒钟后自动跳转到主页.");
          response.setHeader("Refresh", "5;URL=/RefreshHttpServlet");
        }
        
3. 禁用浏览器缓存

        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          response.setHeader("Cache-Control", "no-cache");
          response.setHeader("pragma", "no-cache");
          response.setDateHeader("expires", 0);
          response.setHeader("keywords", "keyword1, keyword2");
        }

4. 使用Referer请求头，来防盗链

        protected void doPost(HttpServletRequest request, HttpServletResponse) {
          doGet(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          response.setContentType("text/html;charset=utf-8");
          PrintWriter printWriter = response.getWriter();

          String referer = request.getHeader("referer");
          String sitePart = request.getScheme() + request.getServerName();

          if (null != referer && referer.startsWith(sitePart)) {
            out.println("正在处理你的请求");
          } else {
            //转发到登录页或者其它广告页
            request.getRequestDispatcher("Login.jsp").forward(request, response);
          }
        }

##### Interface ServletRequest

> public interface ServletRequest
> javax.servlet

1. **Object getAttribute(String name)** - 获取name属性的值(null)
2. **Enumeration getAttributeNames()** - 获取request的所有属性名
3. **String getParameter(String name)** - 获取name参数的值(null)
4. **String getParameterValues(String name)** - 获取name参数的值(多值)
5. **String getCharacterEncoding()** - 获取编码类型
6. **int getContentLength()** - 获取request体的字节长度(-1)
7. **String getContentType()** - 获取MIME type(null)
8. **ServletInputStream getInputStream()** - 获取request体的二进制流
9. **String getLocalAddr()** - 获取IP地址
10. **String getLocalName()**
11. **int getLocalPort()**
12. **String getProtocol()** - 获取HTTP版本
13. **BufferedReader getReader()** - 获取请求体
14. **String getRemoteAddr()** - 获取客户端IP地址
15. **String getRemoteHost()** - 获取客户机最后的代理地址
16. **int getRemotePort()**
17. **String getScheme()** - 获取协议头(http,https,ftp)
18. **int getServerPort()**
19. **boolean isSecure()** - 是否使用安全信道(HTTPS)
20. **void removeAttribute(String name)**
21. **void setAttribute(String name, Object o))**
22. **void setCharacterEncoding(String env)**

##### HttpServletRequest

> public interface HttpServletRequest extends ServletRequest
> javax.servlet.http

1. **String getParameter(String name)** - 获取name参数的值(null)
2. **String getParameterValues(String name)** - 获取name参数的值(多值)

        protected void doPost(HttpServletRequest request, HttpServletResponse) {
          String userName = request.getParameter("userName");
          String password = request.getParameter("password");
          String[] hobby = request.getParameterValues("hobby");

          System.out.println(userName + ", " + password + ", " + Arrays.toString(hobby));
        }

3. **Enumeration getParameterNames()** - 获取所有的参数名

        protected void doPost(HttpServletRequest request, HttpServletResponse) {
          Enumeration names = request.getParamerterNames();
          while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
          }
        }

4. **Map getParameterMap()** - 获取request参数到map中

        protected void doPost(HttpServletRequest request, HttpServletResponse) {
          Map<String, String[]> map = request.getParameterMap();
          for (String name : map.keySet()) {
            String[] values = map.get(name);
            System.out.println(name + ": " + Arrays.toString(values));
          }
        }

5. 字符流和字节流不能混用

        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          //字节流
          response.getWriter().print("Welcome to jie-trancender.org");

          //字符流
          String str = "Hello JTrancender";
          byte[] bytes = str.setBytes();
          response.getOutputStream().write(bytes);

          //响应字节数据
          String path = "F:/ming_rong.png";
          FileInputStream in = new FileInputStream(path);
          byte[] bytes;
          try {
            bytes = readInputStream(in);
          } catch (Exception e) {
            bytes = null;
            e.printStackTrace();
          }

          response.getOutputStream().write(bytes);
        }

6. 获取客户端信息

        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          String addr = request.getRemoteAddr();
          System.out.println("IP: " + addr);
          System.out.println("请求方式: " + request.getMethod());

          String userAgent = request.getHeader("User-Agent");
          if (userAgent.toLowerCase().contains("chrome")) {
            System.out.println("Your ip is " + addr ", request method is " + request.getMethod());
          } else if (....) {
            ......
          }
        }

7. 获取URL

        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          response.getWriter().print(request.getScheme() + "<br/>");
          response.getWriter().print(request.getServerName() + "<br/>");
          response.getWriter().print(request.getServerPort() + "<br/>");
          response.getWriter().print(request.getContextPath() + "<br/>");
          response.getWriter().print(request.getServletPath() + "<br/>");
          response.getWriter().print(request.getQueryString() + "<br/>");
          response.getWriter().print(request.getRequestURL() + "<br/>");
        }

8. 请求转发

    > 转发留头不留尾
    
        protected void doGet(HttpServletRequest request, HttpServletResponse) {
          //头，可用
          response.setHeader("@Auther", "Jason");

          //尾，不可用，直接忽略
          for (int i = 0; i < 24 * 1024 + 1; ++i)
        }

AHttpServlet.java