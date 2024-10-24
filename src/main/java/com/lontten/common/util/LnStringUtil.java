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
 * Created On      : <2024-10-24>
 * Last Modified   : <2024-10-18>
 *
 * lontten-common: Lontten 项目使用的通用组件库
 * ------------------------------------------------------------*/
package com.lontten.common.util;


import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LnStringUtil {

    /**
     * @param str   要分割的字符串
     * @param regex 分割符
     * @param split 附加的过滤符
     * @return 分割后的list
     */
    public static ArrayList<String> split(String str, String regex, String... split) {
        if (str == null) {
            throw new IllegalArgumentException("str is null");
        }
        if (regex == null) {
            throw new IllegalArgumentException("str is null");
        }

        for (String s : split) {
            str = str.replaceAll(s, regex);
        }
        return Arrays.stream(str.split(regex))
                .map(LnStringUtil::term)
                .filter(s -> !s.isBlank())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * @param str   要分割的字符串
     * @param regex 分割符
     * @param split 附加的过滤符
     * @return 分割后的list
     */
    public static ArrayList<String> splitMust(String str, String regex, String... split) {
        if (str == null) {
            return new ArrayList<>();
        }
        return split(str, regex, split);
    }

    /**
     * 常用分隔符
     * ","      "，"
     * ";"      "；"
     * "、"      "/"
     * " "      "\u3000"        "\u00A0"
     *
     * @param str 要分割的字符串
     * @return 分割后的list
     */
    public static ArrayList<String> splitCommon(String str) {
        return split(str, " ", ",", "，", ";", "；", "、", "/", "\u3000", "\u00A0");
    }

    /**
     * 把特殊空格 换成 普通空格,同时对两头空格切除
     * "\u3000" 全角空格
     * "\u00A0" 不换行空格  
     *
     * @param str
     * @return
     */
    public static String term(String str) {
        if (str == null) {
            throw new IllegalArgumentException("str is null");
        }
        str = str.replaceAll("\u3000", " ");
        str = str.replaceAll("\u00A0", " ");

        return str.trim();
    }

    public static String termMust(String str) {
        if (str == null) {
            return "";
        }
        str = str.replaceAll("\u3000", " ");
        str = str.replaceAll("\u00A0", " ");
        return str.trim();
    }

    /**
     * 判断字符串是否为空
     * 会排除 特殊空格
     * "\u3000" 全角空格
     * "\u00A0" 不换行空格  
     *
     * @param str
     * @return
     */
    public static boolean hasText(@Nullable String str) {
        return !noText(str);
    }

    /**
     * 判断字符串是否为空
     * 会排除 特殊空格
     * "\u3000" 全角空格
     * "\u00A0" 不换行空格  
     *
     * @param str
     * @return
     */
    public static boolean noText(@Nullable String str) {
        if (str == null) return true;
        str = str.replaceAll("\u3000", "");
        str = str.replaceAll("\u00A0", "");
        return str.isBlank();
    }
}
