package com.example.servlet1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServletContext extends HttpServlet {

    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取ServletContext对象,srevletContext对象是整个应用唯一的，在任何地方设置了属性，在全应用都能使用
        ServletContext context = getServletContext();

        //根据key获取value
        String encoding = context.getInitParameter("globalEncoding");
        System.out.println(encoding);

        //获取对应的虚拟目录
        String contextPath = context.getContextPath();
        System.out.println(contextPath);

        //根据虚拟路径获取绝对路径
        String contextRealPath = context.getRealPath("/");
        System.out.println(contextRealPath);

        String aRealPath = context.getRealPath("a.txt");
        String bRealPath = context.getRealPath("b.txt");
        String cRealPath = context.getRealPath("c.txt");
        System.out.println(aRealPath);
        System.out.println(bRealPath);
        System.out.println(cRealPath);


        //此时为servletContext设置了属性，在应用的任何地方都能使用
        context.setAttribute("name","zhangsan");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
