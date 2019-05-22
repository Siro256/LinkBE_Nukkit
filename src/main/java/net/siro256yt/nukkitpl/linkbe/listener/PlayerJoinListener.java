package net.siro256yt.nukkitpl.linkbe.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

import net.siro256yt.nukkitpl.linkbe.LinkBE;
import net.siro256yt.nukkitpl.linkbe.database.CreateTmpData;
import net.siro256yt.nukkitpl.linkbe.util.SecureRandomString;

public class PlayerJoinListener implements Listener {
    private final LinkBE plugin;

    public PlayerJoinListener(LinkBE plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String xuid = player.getLoginChainData().getXUID();
        String code = SecureRandomString.generate(8);
        boolean done = false;

        try {
            new CreateTmpData().execute(xuid, code);
            done = true;
        } catch (Exception e) {
            e.printStackTrace();
            done = false;
        }

        if (done == true) {
            player.kick("Your code: " + code + "\n" +
                                "1. Join to auth.dev-jp.net by Java Edition\n" +
                                "2. Enter a command /auth " + code, false);
        } else {
            player.kick("Internal error. Please retry again.", false);
        }
    }
}
