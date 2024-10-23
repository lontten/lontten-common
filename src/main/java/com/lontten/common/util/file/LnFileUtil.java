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
