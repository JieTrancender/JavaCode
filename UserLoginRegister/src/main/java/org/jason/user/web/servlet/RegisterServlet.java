package org.jason.user.web.servlet;

import org.jason.commons.CommonUtils;
import org.jason.user.domain.User;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTrancender on 2017/3/7.
 */
@WebServlet(name = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //依赖UserService
        UserService userService = new UserService();

        /**
         * 1. 封装表单数据到User对象中
         */
//        User from = CommonUtils::toBean(request.getParameterMap(), User.class);
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        /**
         * 表单校验
         *   1. 创建Map用来装载所有的表单错误信息
         *     如果失败，向map添加错误信息，其中key为表单字段名称
         *   2. 校验之后查看map长度是否大于0，如果大于0，保存map到request中，保存form大orequest中，转发到register.jsp中
         *     如果为空，向下执行
         */
        Map<String, String> errors = new HashMap<String, String>();

        String userName = form.getUserName();
        if (null == userName || userName.trim().isEmpty()) {
            errors.put("userName", "用户名不能为空");
        } else if (userName.length() < 6 || userName.length() > 18) {
            errors.put("userName", "用户名长度必须在6~18之间!");
        }

        String password = form.getPassword();
        if (null == password || password.trim().isEmpty()) {
            errors.put("password", "密码不能为空");
        } else if (password.length() < 6 || password.length() > 18) {
            errors.put("password", "密码长度必须在6~18之间!");
        }

        String verifyPassword = form.getVerifyPassword();
        if (null == verifyPassword || verifyPassword.trim().isEmpty()) {
            errors.put("verifyPassword", "确认密码不能为空");
        }  else if (!password.equals(verifyPassword)) {
            errors.put("verifyPassword", "确认密码与密码不一致");
        }

        int age = form.getAge();
        if (age < 0 || age > 120) {
            errors.put("age", "年龄不在正常范围");
        }

        String gender = form.getGender();
        if (null == gender || gender.trim().isEmpty()) {
            errors.put("gender", "性别不能为空");
        } else if (gender.length() < 1 || gender.length() > 18) {
            errors.put("gender", "性别长度必须在1~18之间");
        }

        String verifyCode = form.getVerifyCode();
        String sessionVerifyCode = (String) request.getSession().getAttribute("verifyCode");
        if (null == verifyCode || verifyCode.trim().isEmpty()) {
            errors.put("verifyCode", "验证码不能为空");
        } else if (verifyCode.length() != 4) {
            errors.put("verifyCode", "验证码长度必须为4!");
        } else if (!verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
            errors.put("verifyCode", "验证码错误！");
        }

        if (null != errors && errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.setAttribute("userInfo", form);
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
            return;
        }


        /**
         * 2. 调用userService的register方法，传递form过去
         * 3. 得到异常: 获取异常信息，保存到request域中，转发到register.jsp中
         * 4. 没有异常: 输出注册成功
         */
        try {
            userService.register(form);
            response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/user/login.jsp" + "'>点击这里去登录");
        } catch (UserException e) {
            //获取异常信息，保存到request域中
            request.setAttribute("msg", e.getMessage());
            //保存表单数据到request域中
            request.setAttribute("userInfo", form);
            //转发到register.jsp
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/register.jsp").forward(request, response);
    }
}
