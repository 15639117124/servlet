package com.example.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*

集成HttpServlet，并重写doGet和doPost方法
 */
public class TestServlet2 extends HttpServlet {


    //初始化对象方法
    @Override
    public void init() throws ServletException {
        System.out.println("对象出生了");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGet方法执行了");
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        //super.doPost(req, resp);
    }


    //对象销毁方法
    @Override
    public void destroy() {
        System.out.println("对象销毁");

        super.destroy();
    }
}
