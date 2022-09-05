package cn.docase.server;

import java.io.Serializable;

/**
 * 服务器管理类：用于管理后端数据到前端数据的管理者
 * 1、加一个序列化
 * 2、定义相应的属性：
 * 3、添加构造方法
 * 4、添加set和get方法
 * 5、添加一个toString方法，用于显示服务器管理类的情况
 */
public class ResultBean implements Serializable {
    //定义一个服务器状态是否正常
    private Boolean flag;
    //定义data 表示请求处理结果
    private Object data;
    //errorMsg表示服各器异常信息
    private String errorMsg;
    //构造方法-1:用于创建对象，无参
    public ResultBean(){}
    //构造方法-2：用于初始化服务器状态
    public ResultBean(Boolean flag) {
        this.flag = flag;
    }
    //构造方法-3：服务器状态和异常信息
    public ResultBean(Boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }
    //构造方法-4：表示服务器状态和处理结果
    public ResultBean(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
    //构造方法-5:表示服务器状态、处理结果、异常信息
    public ResultBean(Boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }
    //添加get和set方法

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    //添加一个toString方法

    @Override
    public String toString() {
        return "ResultBean{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
