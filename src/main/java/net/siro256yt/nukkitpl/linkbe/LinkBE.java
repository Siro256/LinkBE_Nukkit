package net.siro256yt.nukkitpl.linkbe;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

import net.siro256yt.nukkitpl.linkbe.listener.PlayerJoinListener;

public class LinkBE extends PluginBase {

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.GREEN + "I've been enabled!");

        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.GREEN + "I've been enabled!");
    }
}
