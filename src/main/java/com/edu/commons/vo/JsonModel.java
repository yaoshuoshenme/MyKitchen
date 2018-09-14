package com.edu.commons.vo;

public class JsonModel {
    private Integer code;
    private String msg;
    private Object data;

    public JsonModel() {
    }

    public JsonModel(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static JsonModel ok(){
        JsonModel js = new JsonModel();
        js.setCode(0);
        js.setMsg("success");
        return js;
    }

    public static JsonModel error(){
        JsonModel js = new JsonModel();
        js.setCode(1);
        js.setMsg("false");
        return js;
    }

    public static JsonModel createJs(Integer code, String msg, Object data){
        return new JsonModel(code,msg,data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
