package com.itheima.web;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService;
        /**
         * 获取 SpringBean
         */

        //方式一:

        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        /**
         *方式二:
         * 自定义监听器:com.itheima.listener.ContextLoaderListener
         * 在监听器内部,将应用上下文的保存到 ServletContext 域中,
         * 在此处从 ServletContext 读取 app,从而获取bean
         */

        ServletContext servletContext = this.getServletContext();
//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");

        // 方式三:自定义工具类获取
        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

//        方式四:通过Spring框架中的工具类
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        userService = app.getBean(UserService.class);
        userService.save();
    }
}
