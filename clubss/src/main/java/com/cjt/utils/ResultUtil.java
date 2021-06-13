package com.cjt.utils;

/**
 * @Description: 统一接口返回值
 * @Author: yanhonghai
 * @Date: 2018/11/14 18:28
 */
public class ResultUtil {
    public static Results success() {
        return success(null);
    }

    public static Results success(Object object) {
        Results result = new Results();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Results success(Integer code, Object object) {
        Results result = new Results();
        result.setCode(code);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Results success(Integer code, String msg, Object object) {
        Results result = new Results();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Results error(String msg) {
        Results result = new Results();
        result.setCode(ResultCode.ERROR);
        result.setMsg(msg);
        return result;
    }

    public static Results error(Integer code, String msg) {
        Results result = new Results();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
