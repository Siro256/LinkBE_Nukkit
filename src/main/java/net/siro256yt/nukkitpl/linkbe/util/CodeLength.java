package net.siro256yt.nukkitpl.linkbe.util;

import net.siro256yt.nukkitpl.linkbe.LinkBE;

public class CodeLength {

    public static int check() {
        int config = Integer.parseInt(LinkBE.code_length);
        int length = 8;

        if(config % 2 == 0) {
            //config値が偶数の場合、そのまま返す
            length = config;
        } else {
            //config値が奇数の場合、+1して返す(7だったら8に)
            //SecureRandomStringは奇数文字数対応してない
            length = config + 1;
        }
        return length;
    }
}
