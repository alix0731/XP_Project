

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://den1.mysql5.gear.host:3306/motorhomedb?autoReconnect=true";
            name = "motorhomedb";
            pass = "Tw00?vT9X?C9";
            conn = DriverManager.getConnection(url, name, pass);
            System.out.println("Connection created");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return conn;
    }
}