package com.lontten.common.core;


import java.util.HashMap;

public class Result<T> {


    //    --------------------- ok ----------------------------------
    private T ok;

    protected void setOk(T ok) {
        this.ok = ok;
    }

    public static <T> Result<T> ok(T ok) {
        Result<T> result = new Result<>();
        result.setOk(ok);
        result.setE(null);
        return result;
    }

    public boolean isOk() {
        if (ok != null) {
            return true;
        }
        return e == null;
    }

    public T getOk() {
        return ok;
    }
    //    --------------------- e ----------------------------------


    private Exception e;

    protected void setE(Exception e) {
        this.e = e;
    }

    public static <T> Result<T> e(Exception e) {
        Result<T> result = new Result<>();
        result.setE(e);
        result.setOk(null);
        return result;
    }

    public static <T> Result<T> e(Exception e, Class<T> clazz) {
        return e(e);
    }

    public boolean hasE() {
        return e != null;
    }

    public Exception getE() {
        return e;
    }

    //    --------------------- map ----------------------------------

    private final HashMap<String, Object> map = new HashMap<>();


    public Result<T> push(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

}
