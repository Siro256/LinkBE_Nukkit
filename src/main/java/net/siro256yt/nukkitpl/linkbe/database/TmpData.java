package net.siro256yt.nukkitpl.linkbe.database;

import net.siro256yt.nukkitpl.linkbe.LinkBE;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class TmpData {
    /**
     * 認証コードを生成する
     * @param xuid XUID(XboxのLongID)
     * @param code 認証コード
     * @return returnしているが特に必要なし
     * @throws Exception
     *
     * @author Siro_256
     * @version 1.0.0
     */
    public static int createTmpData(String xuid, String code) throws Exception {
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis() - 1000*60*60*24);

        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conn = DriverManager.getConnection("jdbc:mysql://" + LinkBE.db_host + "/" + LinkBE.db_name + "?user=" + LinkBE.db_user + "&password=" + LinkBE.db_pass);

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT tmpdata VALUES (?, ?, ?)");

        preparedStatement.setString(1, xuid);
        preparedStatement.setString(2, code);
        preparedStatement.setTimestamp(3, timestamp);

        int resultSet  = preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();
        return resultSet;
    }

    /**
     * DBからデータを取得する
     * @param xuid XUID(XboxのLongID)
     * @return HashMapを返す resultCode->認証コード resultTime->DBに保存されている時間 resultTimeString->DB保存されている時間をStringにしたもの
     * @throws Exception
     *
     * @author Siro_256
     * @version 1.0.0
     */
    public static HashMap<String, String> searchTmpData(String xuid) throws Exception {
        HashMap<String, String> searchData = new HashMap<String, String>();
        String resultCode = null;
        Timestamp resultTime = null;
        String resultTimeString = null;

        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conn = DriverManager.getConnection("jdbc:mysql://" + LinkBE.db_host + "/" + LinkBE.db_name + "?user=" + LinkBE.db_user + "&password=" + LinkBE.db_pass);

        PreparedStatement preparedStatement = conn.prepareStatement("SELECT xuid, code, time FROM tmpdata WHERE xuid = ?");

        preparedStatement.setString(1, xuid);

        ResultSet resultSet  = preparedStatement.executeQuery();

        while (resultSet.next()) {
            resultCode = resultSet.getString("code");
            resultTime = resultSet.getTimestamp("time");
            resultTimeString =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(resultTime);
        }
        searchData.put("searchCode", resultCode);
        searchData.put("searchTimeString", resultTimeString);

        preparedStatement.close();
        conn.close();

        return searchData;
    }

    /**
     * DBに保存されているデータを削除する
     * @param xuid XUID(XboxのLongID)
     * @return returnしているが特に必要なし
     * @throws Exception
     *
     * @author Siro_256
     * @version 1.0.0
     */
    public static int deleteTmpData(String xuid) throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conn = DriverManager.getConnection("jdbc:mysql://" + LinkBE.db_host + "/" + LinkBE.db_name + "?user=" + LinkBE.db_user + "&password=" + LinkBE.db_pass);

        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM tmpdata WHERE xuid = ?");

        preparedStatement.setString(1, xuid);

        int resultSet  = preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();

        return resultSet;
    }
}
