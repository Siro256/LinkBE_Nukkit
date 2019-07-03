package net.siro256yt.nukkitpl.linkbe.util;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;

public class Kick {
    public static void normal(Player player, String code) {
        player.kick("Your code: " + TextFormat.RED + code + TextFormat.RESET + "\n" +
                "1. Join to " + TextFormat.BLUE + "auth.dev-jp.net" + TextFormat.RESET + " by Java Edition\n" +
                "2. Enter a command " + TextFormat.RED + "/auth " + code, false);
    }

    public static void error(Player player) {
        player.kick("Internal error. Please retry again.", false);
    }

}
