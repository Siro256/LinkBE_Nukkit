package net.siro256yt.nukkitpl.linkbe.util;

import java.security.SecureRandom;

public class SecureRandomString {
    /**
     * 文字数を指定し、SecureRandomで安全なランダム文字列を生成する
     * @param length 文字数
     * @return 指定した文字数の認証コード
     *
     * @author Siro_256
     * @version 1.0.0
     */
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
