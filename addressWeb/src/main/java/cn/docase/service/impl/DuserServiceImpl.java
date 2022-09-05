package cn.docase.service.impl;

import cn.docase.bean.Duser;
import cn.docase.dao.DuserDao;
import cn.docase.dao.impl.DuserDaoImpl;
import cn.docase.service.DuserService;

import java.sql.SQLException;
import java.util.List;

public class DuserServiceImpl implements DuserService {
    //创建dao接口对象并通过dao实现类来实例化
    DuserDao duserDao=new DuserDaoImpl();
    @Override
    public int add(Duser duser) throws SQLException {
        return duserDao.add(duser);
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        return duserDao.deleteById(id);
    }

    @Override
    public void update(Duser duser) throws SQLException {
        duserDao.update(duser);
    }

    @Override
    public Duser findByUser(String name, String pwd) throws SQLException {
        return duserDao.findByUser(name,pwd);
    }

    @Override
    public Duser findById(Integer id) throws SQLException {
        return duserDao.findById(id);
    }

    @Override
    public List<Duser> findAll() throws SQLException {
        return duserDao.findAll();
    }
}
