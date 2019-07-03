package net.siro256yt.nukkitpl.linkbe.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;

import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.Plugin;
import net.siro256yt.nukkitpl.linkbe.database.TmpData;
import net.siro256yt.nukkitpl.linkbe.util.CodeLength;
import net.siro256yt.nukkitpl.linkbe.util.Kick;
import net.siro256yt.nukkitpl.linkbe.util.SecureRandomString;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class PlayerJoinListener implements Listener {
    public PlayerJoinListener(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        HashMap<String, String> searchData;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        Timestamp nowTimeTimestamp = new Timestamp(Calendar.getInstance().getTimeInMillis() - 1000*60*60*24);
        String xuid = player.getLoginChainData().getXUID();
        String code = SecureRandomString.generate(CodeLength.check());
        String searchCode = null;
        String searchTimeString;
        Date nowTime;
        Date searchTime;
        long nowTimeLong;
        long searchTimeLong;
        long minDiff = 0;
        boolean create;
        boolean search;
        boolean isCreated = true;

        try {
            searchData = new TmpData().searchTmpData(xuid);

            searchCode = searchData.get("searchCode");
            searchTimeString = searchData.get("searchTimeString");
            searchTime = simpleDateFormat.parse(searchTimeString);

            nowTime = simpleDateFormat.parse(String.valueOf(nowTimeTimestamp));

            nowTimeLong = nowTime.getTime();
            searchTimeLong = searchTime.getTime();
            minDiff = (nowTimeLong - searchTimeLong) / (1000*60);

            search = true;
        } catch (Exception e) {
            e.printStackTrace();
            search = false;
            isCreated = false;
        }

        if (search) {
            if (31 <= minDiff) {
                try {
                    TmpData.deleteTmpData(xuid);
                    isCreated = false;
                } catch (Exception e) {
                    Kick.error(player);
                    e.printStackTrace();
                }
            } else {
                Kick.normal(player, searchCode);
            }
        }
            if (!isCreated) {
                try {
                    new TmpData().createTmpData(xuid, code);
                    create = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    Kick.error(player);
                    create = false;
                }

                if (create) {
                    Kick.normal(player, code);
                } else {
                    Kick.error(player);
                }
            }
    }
}
