package net.siro256yt.nukkitpl.linkbe;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

import net.siro256yt.nukkitpl.linkbe.listener.PlayerJoinListener;

public class LinkBE extends PluginBase {
    public static String db_host;
    public static String db_port;
    public static String db_name;
    public static String db_user;
    public static String db_pass;

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.GREEN + "I've been enabled!");

        this.saveConfig();
        this.saveDefaultConfig();

        db_host = getConfig().get("db-host", "localhost");
        db_port = getConfig().get("db-port", "3306");
        db_name = getConfig().get("db-name", "linkbe");
        db_user = getConfig().get("db-user", "root");
        db_pass = getConfig().get("db-pass", "");


        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.GREEN + "I've been enabled!");
    }
}
