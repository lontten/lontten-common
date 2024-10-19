package com.lontten.common.util.math;

import java.util.HexFormat;

import static com.lontten.common.util.LnStringUtil.noText;

public class LnHexUtil {
    public static HexFormat hexFormat = HexFormat.of();


    //十六进制字符串转换为byte[]数组
    public static byte[] hexString2bytes(String hexString) {
        if (noText(hexString)) {
            throw new IllegalArgumentException("hexString no text");
        }
        return hexFormat.parseHex(hexString);
    }

    //十六进制字符串转换为字符串
    public static String hexString2string(String hexString) {
        byte[] bytes = hexString2bytes(hexString);
        return new String(bytes);
    }


    //    byte[]字节数组转十六进制字符串
    public static String bytes2hexString(byte[] bytes) {
        return hexFormat.formatHex(bytes);
    }

    //字符串转换为十六进制字符串
    public static String string2hexString(String str) {
        if (noText(str)) {
            throw new IllegalArgumentException("str no text");
        }
        return bytes2hexString(str.getBytes());
    }


}
