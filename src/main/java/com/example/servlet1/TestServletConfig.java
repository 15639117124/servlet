package com.example.servlet1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TestServletConfig extends HttpServlet {


    //生命servletConfig
    private ServletConfig servletConfig;


    //servletConfig对象是由服务器提供的，此时在init方法中赋值
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("测试servletConfig类");
        //演示servletConfig的常用方法

        //根据key获取value
        String encodingValue = servletConfig.getInitParameter("encoding");
        System.out.println(encodingValue);

        //获取所有的key
        Enumeration<String> keys = servletConfig.getInitParameterNames();
        while (keys.hasMoreElements()) {

            String key = keys.nextElement();
            //根据key获取value
            String value = servletConfig.getInitParameter(key);
            System.out.println("key:"+key+"-----value:"+value);
        }

        //获取servletContext对象,servletConfig对象又服务器提供
        ServletContext servletContext = servletConfig.getServletContext();

        System.out.println(servletContext.getAttribute("name"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
