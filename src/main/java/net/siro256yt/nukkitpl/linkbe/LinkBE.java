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
    public static String code_length;

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
        code_length = getConfig().get("code-length", "8");


        new PlayerJoinListener(this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.GREEN + "I've been disabled!");
    }
}
