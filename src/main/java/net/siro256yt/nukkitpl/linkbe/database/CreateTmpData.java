package net.siro256yt.nukkitpl.linkbe.database;

import net.siro256yt.nukkitpl.linkbe.LinkBE;

import java.sql.*;
import java.util.Calendar;

public class CreateTmpData {
    public static void execute(String xuid, String code) throws Exception {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis() - 1000*60*60*24);

        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conn = DriverManager.getConnection("jdbc:mysql://" + LinkBE.db_host + "/" + LinkBE.db_name + "?user=" + LinkBE.db_user + "&password=" + LinkBE.db_pass);

        //PreparedStatement pstmt = conn.prepareStatement("INSERT tmpdata VALUES (" + xuid + ", '" + code + "', '" + ZonedDateTime.now() + "')");
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT tmpdata VALUES (?, ?, ?)");

        preparedStatement.setString(1, xuid);
        preparedStatement.setString(2, code);
        preparedStatement.setTimestamp(3, timestamp);

        int rs  = preparedStatement.executeUpdate();

        //rs.close();
        preparedStatement.close();
        conn.close();
    }
}
