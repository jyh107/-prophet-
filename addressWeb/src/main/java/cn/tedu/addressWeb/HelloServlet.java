package cn.tedu.addressWeb;

import cn.docase.bean.Duser;
import cn.docase.service.DuserService;
import cn.docase.service.impl.DuserServiceImpl;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
       doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置参数字符集
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("userName");
        String pwd=request.getParameter("userPwd");
        String email=request.getParameter("email");
        //创建实体对象
        Duser duser=new Duser(name,pwd,email);
        //创建服层对象并实例化
        DuserService duserService=new DuserServiceImpl();
        //处理
        try {
            int i=duserService.add(duser);
            if (i==1){
                System.out.println("添加成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}