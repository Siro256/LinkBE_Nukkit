package net.siro256yt.nukkitpl.linkbe.util;

import java.security.SecureRandom;

public class SecureRandomString {

    public static String generate(int length) {
        int length2 = length / 2;
        byte bytes[] = new byte[length2];
        StringBuffer buffer = new StringBuffer();

            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(bytes);

            //TODO 文字数が奇数でも生成できるようにする
            for (int i = 0; i < bytes.length; i++) {
                buffer.append(String.format("%02x", bytes[i]));
            }

        return buffer.toString();
    }
}
