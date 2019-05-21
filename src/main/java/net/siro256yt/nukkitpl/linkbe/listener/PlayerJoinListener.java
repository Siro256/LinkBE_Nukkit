package net.siro256yt.nukkitpl.linkbe.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;

import cn.nukkit.event.player.PlayerJoinEvent;
import net.siro256yt.nukkitpl.linkbe.LinkBE;

public class PlayerJoinListener implements Listener {

    private final LinkBE plugin;

    public PlayerJoinListener(LinkBE plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {

    }
}
