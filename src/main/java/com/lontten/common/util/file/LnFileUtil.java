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
 * Last Modified   : <2024-10-23>
 *
 * lontten-common: Lontten 项目使用的通用组件库
 * ------------------------------------------------------------*/
package com.lontten.common.util.file;

import com.google.common.base.Preconditions;
import com.lontten.common.util.lang.LnStringUtil;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class LnFileUtil {
    private static String sysTmpDirPath = System.getProperty("java.io.tmpdir");

    public static String getSuffix(@Nullable File file) {
        Preconditions.checkNotNull(file, "file is null");
        return getSuffix(file.getName());
    }

    public static String getSuffix(@Nullable String fileName) {
        Preconditions.checkArgument(LnStringUtil.hasText(fileName), "fileName no text");
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1);
    }

    public static String getName(@Nullable File file) {
        Preconditions.checkNotNull(file, "file is null");
        return getName(file.getName());
    }

    public static String getName(@Nullable String fileName) {
        Preconditions.checkArgument(LnStringUtil.hasText(fileName), "fileName no text");
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return fileName;
        }
        return fileName.substring(0, lastDotIndex);
    }


    /**
     * 如果文件已存在，直接返回；
     * 不存在时，创建
     * 当 文件所在目录不存在时，先创建目录，再创建文件
     *
     * @param path 文件路径， 最后不能以 "/" 结尾。
     * @return File
     * @throws IOException 创建文件异常(路径异常)
     */
    public static File createFile(@Nullable String path) throws IOException {
        Preconditions.checkArgument(LnStringUtil.hasText(path), "path no text");
        Preconditions.checkArgument(!path.endsWith("/"), "path is dir.");

        File file = new File(path);
        File parentFile = file.getParentFile();
        parentFile.mkdirs();
        file.createNewFile();
        return file;
    }

    /**
     * 如果文件已存在，直接返回；
     * 不存在时，创建
     * 当 文件所在目录不存在时，先创建目录，再创建文件
     *
     * @param path 目录路径， 最后必须以 "/" 结尾
     * @return File
     * @throws IOException 创建文件异常(路径异常)
     */
    public static File createDir(@Nullable String path) throws IOException {
        Preconditions.checkArgument(LnStringUtil.hasText(path), "path no text");
        Preconditions.checkArgument(!path.endsWith("/"), "path is not a dir.");

        File file = new File(path);
        file.mkdirs();
        return file;
    }


    /**
     * 系统 临时文件，当系统 退出时，自动删除。
     *
     * @param prefix 文件 前缀名
     * @param suffix 文件 后缀名
     * @return File
     * @throws IOException 创建文件异常(路径异常)
     */
    public static File createSysTempFile(@Nullable String prefix, @Nullable String suffix) throws IOException {
        Preconditions.checkArgument(LnStringUtil.hasText(prefix), "prefix no text");
        Preconditions.checkArgument(LnStringUtil.hasText(suffix), "suffix no text");
        Preconditions.checkArgument(!prefix.contains("/"), "prefix has / ");
        Preconditions.checkArgument(!suffix.contains("/"), "suffix has / ");

        return createSysTempFile(prefix + "." + suffix);
    }

    /**
     * jvm 临时文件，当应用退出时，自动删除。
     *
     * @param prefix 文件 前缀名
     * @param suffix 文件 后缀名
     * @return File
     * @throws IOException 创建文件异常(路径异常)
     */
    public static File createJvmTempFile(@Nullable String prefix, @Nullable String suffix) throws IOException {
        Preconditions.checkArgument(LnStringUtil.hasText(prefix), "prefix no text");
        Preconditions.checkArgument(LnStringUtil.hasText(suffix), "suffix no text");
        Preconditions.checkArgument(!prefix.contains("/"), "prefix has / ");
        Preconditions.checkArgument(!suffix.contains("/"), "suffix has / ");

        File file = File.createTempFile(prefix, suffix);
        file.deleteOnExit();
        return file;
    }

    /**
     * 系统 临时文件，当系统 退出时，自动删除。
     *
     * @param fileName 文件名
     * @return File
     * @throws IOException 创建文件异常(路径异常)
     */
    public static File createSysTempFile(@Nullable String fileName) throws IOException {
        Preconditions.checkArgument(LnStringUtil.hasText(fileName), "fileName no text");
        Preconditions.checkArgument(!fileName.contains("/"), "fileName has / ");
        Path path = Paths.get(sysTmpDirPath, UUID.randomUUID().toString(), fileName);
        return createFile(path.toString());
    }


    /**
     * jvm 临时文件，当应用退出时，自动删除。
     *
     * @param fileName 文件名
     * @return File
     * @throws IOException 创建文件异常(路径异常)
     */
    public static File createJvmTempFile(@Nullable String fileName) throws IOException {
        Preconditions.checkArgument(LnStringUtil.hasText(fileName), "fileName no text");
        int lastDotIndex = fileName.lastIndexOf('.');
        Preconditions.checkArgument(lastDotIndex != -1, "no suffix ");
        String prefix = fileName.substring(0, lastDotIndex);
        String suffix = fileName.substring(lastDotIndex + 1);

        return createJvmTempFile(prefix, suffix);
    }


}
