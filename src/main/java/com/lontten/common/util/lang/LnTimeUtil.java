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
 * Last Modified   : <2024-11-12>
 *
 * lontten-common: Lontten 项目使用的通用组件库
 * ------------------------------------------------------------*/
package com.lontten.common.util.lang;

import java.time.format.DateTimeFormatter;

public class LnTimeUtil {
    public static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    public static String dateFormat = "yyyy-MM-dd";
    public static String timeFormat = "HH:mm:ss";

    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
    public static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeFormat);


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
