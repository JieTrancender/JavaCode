package org.jason.user.dao;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jason.user.domain.User;

import java.io.*;

/**
 * 数据类
 * Created by JTrancender on 2017/3/7.
 */
public class UserDao {
    private String path = "F:/JavaCode/users.xml";

    /**
     * Function: 按用户名查找
     * @param userName
     * @return
     */
    public User findByUserName(String userName) {
        /**
         * 1. 得到Document
         * 2. xpath查询
         * 3. 校验查询结果是否为null，如果为null，返回null
         * 4. 如果不为null，需要把Element封装到User对象中
         */
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            Element ele = (Element) doc.selectSingleNode("//user[@userName='" + userName + "']");

            if (null == ele) {
                return null;
            }

            User user = new User();
            String attrUserName = ele.attributeValue("userName");
            String attrPassword = ele.attributeValue("password");
            user.setUserName(attrUserName);
            user.setPassword(attrPassword);

            return user;
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Function: 添加用户到文件或者数据库
     */
    public void add(User user) {
        /**
         * 1. 得到Document
         * 2. 通过Document得到root元素
         * 3. 使用参数user，转发到Element对象
         * 4. 把Element添加到root元素中
         * 5. 保存Document
         */
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);

            //得到跟元素
            Element root = doc.getRootElement();

            //通过根元素创建新元素
//            Element userEle = root.element("user");
            Element userEle = root.addElement("user");

            //为userEle设置属性
            userEle.addAttribute("userName", user.getUserName());
            userEle.addAttribute("password", user.getPassword());

            //保存文档
            OutputFormat format = new OutputFormat("\t", true);//缩进使用'\t'，换行
            format.setTrimText(true);//清空原有的换行

            XMLWriter xmlWriter = new XMLWriter();
            try {
                xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"), format);
                xmlWriter.write(doc);
                xmlWriter.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Function: 获取User验证码
     */
    public String getVerifyCode(User user) {
        return user.getVerifyCode();
    }
}
