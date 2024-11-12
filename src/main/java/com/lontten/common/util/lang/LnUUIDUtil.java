package com.lontten.common.util.lang;

import java.util.UUID;

public class LnUUIDUtil {
    public static UUID formStringToUUID(String uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("字符串为空，无法转成为UUID");
        }
        StringBuilder sb = new StringBuilder();
        if (uuid.length() == 32) {
            sb.append(uuid, 0, 8);
            sb.append("-");
            sb.append(uuid, 8, 12);
            sb.append("-");
            sb.append(uuid, 12, 16);
            sb.append("-");
            sb.append(uuid, 16, 20);
            sb.append("-");
            sb.append(uuid.substring(20));
            uuid = sb.toString();
        }

        if (uuid.length() != 36) {
            throw new IllegalArgumentException("字符串为" + uuid.length() + "，无法转成为UUID");
        }
        return UUID.fromString(uuid);
    }


}

