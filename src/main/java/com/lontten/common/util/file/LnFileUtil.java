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
 * Created On      : <2024-10-23>
 * Last Modified   : <2024-10-23>
 *
 * lontten-common: Lontten 项目使用的通用组件库
 * ------------------------------------------------------------*/
package com.lontten.common.util.file;

import java.io.File;

public class LnFileUtil {
    public static String getSuffix(File file) {
        return getSuffix(file.getName());
    }

    public static String getSuffix(String fileFullName) {
        int lastDotIndex = fileFullName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        }
        return fileFullName.substring(lastDotIndex + 1);
    }

    public static String getName(File file) {
        return getName(file.getName());
    }

    public static String getName(String fileFullName) {
        int lastDotIndex = fileFullName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return fileFullName;
        }
        return fileFullName.substring(0, lastDotIndex);
    }

}
