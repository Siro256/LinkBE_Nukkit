package net.siro256yt.nukkitpl.linkbe.util;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;

public class Kick {
    /**
     * 認証コードを返す通常のkick処理
     * @param player event.getPlayer()
     * @param code 認証コード
     *
     * @author Siro_256
     * @version 1.0.0
     */
    public static void normal(Player player, String code) {
        player.kick("Your code: " + TextFormat.RED + code + TextFormat.RESET + "\n" +
                "1. Join to " + TextFormat.BLUE + "auth.dev-jp.net" + TextFormat.RESET + " by Java Edition\n" +
                "2. Enter a command " + TextFormat.RED + "/auth " + code, false);
    }

    /**
     * エラーが発生した場合に行うkick処理
     * @param player event.getPlayer()
     *
     * @author Siro_256
     * @version 1.0.0
     */
    public static void error(Player player) {
        player.kick("Internal error. Please retry again.", false);
    }

}
