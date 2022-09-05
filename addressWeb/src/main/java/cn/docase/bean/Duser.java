package cn.docase.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 1、将该实体类添添加一个序列化：就是为了保存在内存中各种对象的状态
 *      implements Serializable
 * 2、将数据库表的字段私有实例化，用封装类型
 * 3、添加构造方法
 *    a、定义一个无参构造方法：用于实例化用
 *    b、定义一个有参数的构造方法：用于实例化记录对象用的
 * 4、给各属性添加set和get方法
 * 5、添加一个toString()方法：用于后期输出用
 */
public class Duser implements Serializable {
    //定义属性
    private Integer pk_id;
    private String name;
    private String pwd;
    private String email;
    private Date d_create;
    private Date d_modified;
    //添加构造方法
    public Duser(){}
    public Duser(String name, String pwd, String email) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
    }
    //添加set和get方法

    public Integer getPk_id() {
        return pk_id;
    }

    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getD_create() {
        return d_create;
    }

    public void setD_create(Date d_create) {
        this.d_create = d_create;
    }

    public Date getD_modified() {
        return d_modified;
    }

    public void setD_modified(Date d_modified) {
        this.d_modified = d_modified;
    }
    //添加toString方法

    @Override
    public String toString() {
        return "Duser{" +
                "pk_id=" + pk_id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", d_create=" + d_create +
                ", d_modified=" + d_modified +
                '}';
    }
}
