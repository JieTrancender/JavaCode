package org.jason.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/3.
 * SimpleTagSupport实现了SimpleTag接口，将所有tomcat传递的数据都保存起来了，并且提供leget方法供子类使用
 */
public class MySimpleTagSupport extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
//        super.doTag();
        this.getJspContext().getOut().print("Hello SimpleTagSupport");
    }
}
