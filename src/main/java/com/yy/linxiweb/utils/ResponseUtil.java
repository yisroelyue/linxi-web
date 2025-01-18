package com.yy.linxiweb.utils;


import com.yy.linxiweb.bo.Response;

public class ResponseUtil<T> {

    Integer SUCCESS_CODE = 0;
    String SUCCESS = "success";

    Integer FAIL_CODE = -1;
    String FAIL = "failed";

    public Response<T> success(T obj){
        Response<T> res = new Response<>();
        res.setCode(SUCCESS_CODE);
        res.setData(obj);
        res.setMsg(SUCCESS);
        return res;
    }

    public Response<T> success(){
        Response res = new Response<>();
        res.setCode(SUCCESS_CODE);
        res.setMsg(SUCCESS);
        return res;
    }

    public Response<T> success(String msg, T obj){
        Response<T> res = new Response<>();
        res.setCode(SUCCESS_CODE);
        res.setData(obj);
        res.setMsg(msg);
        return res;
    }

    public Response<T> error(Integer code, String msg){
        Response res = new Response<>();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    public Response error(){
        return error(FAIL_CODE, FAIL);
    }

    public Response<T> error(String msg){
        return error(FAIL_CODE, msg);
    }

    public Response serviceException(Integer code, String msg){
        Response res = new Response<>();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    public Response systemException(Integer code, String msg){
        Response res = new Response<>();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    @SuppressWarnings("unused")
    public Response serviceException(String msg){
        return serviceException(FAIL_CODE, msg);
    }



}