package net.siro256yt.nukkitpl.linkbe.database;

import net.siro256yt.nukkitpl.linkbe.LinkBE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class CreateTmpData {
    public static void execute(String xuid, String code) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Class.forName("com.mysql.jdbc.Driver").newInstance();

        conn = DriverManager.getConnection("jdbc:mysql://" + LinkBE.db_host + "/" + LinkBE.db_name + "?user=" + LinkBE.db_user + "&password=" + LinkBE.db_pass);

        pstmt = conn.prepareStatement("INSERT tmpdata VALUES (" + xuid + ", '" + code + "', '" + LocalDateTime.now() + "')");
        rs = pstmt.executeQuery();

        rs.close();
        pstmt.close();
        conn.close();
    }
}
