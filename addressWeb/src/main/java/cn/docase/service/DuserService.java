package cn.docase.service;

import cn.docase.bean.Duser;

import java.sql.SQLException;
import java.util.List;

public interface DuserService {
    //定义一个接口方法用于完成添加记录
    public int add(Duser duser) throws SQLException;
    //定义一个方法用于根据id进行删除
    public int deleteById(Integer id) throws SQLException;
    //定义一个方法用于修改数据
    public void update(Duser duser) throws SQLException;
    //定义一个方法用于用户登陆
    public Duser findByUser(String name,String pwd) throws SQLException;
    //定义一个方法根据id进行查询
    public Duser findById(Integer id) throws SQLException;
    //定义一个方法用于完成所的查询
    public List<Duser> findAll() throws SQLException;
}
