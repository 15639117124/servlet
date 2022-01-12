package com.example.servlet1;


import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//测试servlet的线程安全问题
//验证结果为servlet为线程不安全的
/*
解决办法：
1、把userName定义在方法里面
2、加上synchronized代码块
 */
public class TestServlet3 extends HttpServlet {
    private String userName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            userName =req.getParameter("userName");

        synchronized (this){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(userName);
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("hello:"+userName);
            printWriter.close();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
