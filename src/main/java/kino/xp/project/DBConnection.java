package kino.xp.project;


import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection
{

    private static Connection conn;


    /**
     * @Author Norsker, Rasmus
     * @return Connection to the DB.
     */

    public static Connection getDatabaseConnection()
    {
        if (conn != null) return conn;
        String name, pass, url;
        try {
            url = "jdbc:mysql://den1.mysql4.gear.host:3306/kinoxp?autoReconnect=true";
            Class.forName("com.mysql.cj.jdbc.Driver");
            name = "kinoxp";
            pass = "Vn5S7Uz_h7_W";
            conn = DriverManager.getConnection(url, name, pass);
            System.out.println("Connection created");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return conn;
    }
}