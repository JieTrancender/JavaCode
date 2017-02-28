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


