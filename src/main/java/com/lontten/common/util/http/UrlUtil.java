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
 * Created On      : <2024-11-14>
 * Last Modified   : <2024-11-14>
 *
 * lontten-common: Lontten 项目使用的通用组件库
 * ------------------------------------------------------------*/
package com.lontten.common.util.http;

import javax.annotation.Nullable;
import java.util.UUID;

public class UrlUtil {

    // 定义需要替换的字符集合
    private static final String[] UNSAFE_CHARS = {
            " ", "\t", "\n", " ",
            "#", "%", "?", ":", "@", "&", "=", "+", "$", ",", "/", ";", "'", "\"",
            "<", ">", "[", "]", "{", "}", "|", "\\", "^", "`", "~", "%" // 注意：这里的%是单独列出的，因为%后需要跟两位十六进制数才是有效的URL编码
    };

    // 将不安全的字符替换为下划线的映射
    private static final String REPLACEMENT_CHAR = "_";


    /**
     * 在尽量保证原名的情况下，让文件名更安全，不会出现url解析问题
     * 将传入的字符串参数中的不安全字符替换为下划线，以使其更适合用作URL的一部分。
     *
     * @param name 需要处理的字符串。
     * @return 处理后的字符串，不安全字符被替换为下划线。
     */
    @Nullable
    public static String softName(@Nullable String name) {
        if (name == null) {
            return null;
        }

        StringBuilder safeName = new StringBuilder();
        for (char c : name.toCharArray()) {
            boolean isUnsafe = false;
            for (String unsafeChar : UNSAFE_CHARS) {
                if (Character.toString(c).equals(unsafeChar)) {
                    isUnsafe = true;
                    break;
                }
            }
            if (isUnsafe) {
                safeName.append(REPLACEMENT_CHAR);
            } else {
                safeName.append(c);
            }
        }

        String result = safeName.toString();
        // 如果字符串为空
        // 则返回一个默认值或进行特殊处理（这里选择返回一个默认值）
        if (result.isEmpty()) {
            return UUID.randomUUID().toString();
        }
        return result;
    }
}
