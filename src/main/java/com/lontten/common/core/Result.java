/* ------------------------------------------------------------
 *   Copyright 2024 lontten lontten@163.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * -------------------------------------------------------------
 * Project Name    :  lontten-common
 * Project Authors :  lontten   <lontten@163.com>
 * Contributors    :  xxxx   <xx@xx.com>
 *                 |  yyyy   <yy@yy.com>
 * Created On      : <2024-10-18>
 * Last Modified   : <2024-10-18>
 *
 * lontten-common: Lontten 项目使用的通用组件库
 * ------------------------------------------------------------*/
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
