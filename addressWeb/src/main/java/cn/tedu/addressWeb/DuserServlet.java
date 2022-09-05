package cn.tedu.addressWeb;

import cn.docase.bean.Duser;
import cn.docase.server.ResultBean;
import cn.docase.service.DuserService;
import cn.docase.service.impl.DuserServiceImpl;
import cn.docase.utils.JsonUtils;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DuserServlet", value = "/DuserServlet")
public class DuserServlet extends HttpServlet {
    //创建服务层对象
    DuserService duserService=new DuserServiceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置获取参数的字符集
        request.setCharacterEncoding("utf-8");
        //获取请求的参数
        String actionAddress=request.getParameter("action");
        try {
            //获取当前类的实例
            Class cls=this.getClass();
            //根据方法名获取方法
            Method method=cls.getDeclaredMethod(actionAddress,HttpServletRequest.class,HttpServletResponse.class);
            //调用指定方法
            method.invoke(this,request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //自定义方法用于完成注册
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //获取参数
        String name=request.getParameter("userName");
        String pwd=request.getParameter("userPwd1");
        String email=request.getParameter("email");
        //创建实体对象
        Duser duser=new Duser(name,pwd,email);
        //创建服务层接口对象并实例化
        DuserService duserService=new DuserServiceImpl();
        //定义一个变量用于接收返回的值
        try {
            int i=duserService.add(duser);
            if (i==1){
                response.sendRedirect("success.html");
            }else {
                response.sendRedirect("error.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //自定义一个方法用于完成登陆
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //取参数
        String name=request.getParameter("userName");
        String pwd=request.getParameter("userPwd");

        try {
            //定义个Duser对象用于接收是否查到用户对象
            Duser duser= duserService.findByUser(name,pwd);
            if (duser!=null){
                response.sendRedirect("index.html");
            }else {
                response.sendRedirect("error.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //自定义个方法用于返回所有数据
    public void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //1创建服务器管理类对象并实例化为正常
        ResultBean resultBean=new ResultBean(true);
        //2开始操作
        try {
            //3调用服务层里的方法
            List<Duser> dusers= duserService.findAll();
            //4将查询的结果装到服务器对象里
            resultBean.setData(dusers);
        }catch (Exception e){
            e.printStackTrace();
            //5给前端返回一个错误提示信息
            resultBean.setFlag(false);
            resultBean.setErrorMsg("获取联系人失败");
        }
        //6将结果输出页面客户端：使用JsonUtil将resultBean对象转换成json字符串输出到客户
        JsonUtils.printResult(response,resultBean);
    }
    //自定义一个方法用于根据id删除指定的记录
    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //1创建服务管理类产对象实初始化服务器状态
        ResultBean resultBean=new ResultBean(true);
        //2获取id值
        Integer id=Integer.valueOf(request.getParameter("id"));
        //3调用业务方法
        try {
            duserService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            resultBean.setFlag(true);
            resultBean.setErrorMsg("删除失败");
        }
        //4将服务管理类对象输出到客户端
        JsonUtils.printResult(response,resultBean);
    }
    //自定义一个方法，根据ID进行查询
    public void findById(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1创建服务管理类产对象实初始化服务器状态
        ResultBean resultBean = new ResultBean(true);
        //2获取联系人的id
        Integer id=Integer.valueOf(request.getParameter("id"));
        //3调用我们服务层业务逻辑
        try {
            //4创建一个duser对象用于接收查看的结果
            Duser duser=duserService.findById(id);
            //5将响应的结果装到服务器管理类中
            resultBean.setData(duser);
        }catch (Exception e){
            e.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("获取联系人失败");
        }
        //6将服务管理类对象输出到客户端
        JsonUtils.printResult(response,resultBean);
    }
    //自定义一个方法用于完成修改
    public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1创建服务管理类产对象实初始化服务器状态
        ResultBean resultBean = new ResultBean(true);
        //2取页面传过来值，duser对象，我们需要转换
        Duser duser=JsonUtils.parseJSON2Object(request,Duser.class);
        //3调用服务层业务方法
        try{
            duserService.update(duser);
        }catch (Exception e){
            e.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("修改失败");
        }
        //4将服务管理类对象输出到客户端
        JsonUtils.printResult(response,resultBean);
    }

}
