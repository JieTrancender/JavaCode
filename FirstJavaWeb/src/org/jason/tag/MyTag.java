package org.jason.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/3.
 */
public class MyTag implements SimpleTag {
    private PageContext pageContext;
    private JspFragment body;

    /**
     * 所有的setXXX方法都会在doTag方法之前被tomcat调用
     * 所以doTag中就可以使用tomcat传递过来的对象
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        pageContext.getOut().print("Hello Tag");
    }

    @Override
    public void setParent(JspTag jspTag) {
    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.pageContext = (PageContext) jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        this.body = jspFragment;
    }
}
