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

public class ResultMsg<T> {


    //    --------------------- ok ----------------------------------
    private T ok;

    protected void setOk(T ok) {
        this.ok = ok;
    }

    public static <T> ResultMsg<T> ok(T ok) {
        ResultMsg<T> result = new ResultMsg<>();
        result.setOk(ok);
        result.setErrMsg(null);
        return result;
    }

    public boolean isOk() {
        if (ok != null) {
            return true;
        }
        return errMsg == null;
    }

    public T getOk() {
        return ok;
    }
    //    --------------------- e ----------------------------------


    private String errMsg;

    protected void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static <T> ResultMsg<T> errMsg(String errMsg) {
        ResultMsg<T> result = new ResultMsg<>();
        result.setErrMsg(errMsg);
        result.setOk(null);
        return result;
    }

    public static <T> ResultMsg<T> errMsg(String errMsg, Class<T> clazz) {
        return errMsg(errMsg);
    }

    public boolean hasErrMsg() {
        return errMsg != null;
    }

    public String getErrMsg() {
        return errMsg;
    }


    //    --------------------- map ----------------------------------

    private final HashMap<String, Object> map = new HashMap<>();

    public ResultMsg<T> push(String key, Object value) {
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
