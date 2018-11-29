package com.lark.xw.business.main.mvp.entity.userLogin;

public class Register {

    /**
     * message : 注册失败，用户名已经存在
     * success : 0为失败,1为成功
     * data : null
     */

    private String message;
    private int success;
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
