package kino.xp.project;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DBTest
{


    @Test
    public void testConnection()
    {

        Connection conn = DBConnection.getDatabaseConnection();

        if (conn==null)
            System.out.println("Error : no connection to database. Contact Rasmus or Norsker");

        assert conn != null;
    }


}
