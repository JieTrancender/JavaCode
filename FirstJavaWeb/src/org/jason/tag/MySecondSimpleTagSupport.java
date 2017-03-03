package org.jason.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by JTrancender on 2017/3/3.
 */
public class MySecondSimpleTagSupport extends SimpleTagSupport {

    private boolean test;

    /**
     * 这个方法会由tomcat来调用，并且在doTag之前
     * @param test
     */
    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
//        super.doTag();
//        this.getJspBody().invoke(null);//如果传递的输出流为null，表示使用的就是当前页面的out

        Writer out = this.getJspContext().getOut();
        out.write("*************<br/>");
        this.getJspBody().invoke(out);
        out.write("*************<br/>");

        if (test) {
            //跳过页面异常
            throw new SkipPageException();
        }
    }
}
