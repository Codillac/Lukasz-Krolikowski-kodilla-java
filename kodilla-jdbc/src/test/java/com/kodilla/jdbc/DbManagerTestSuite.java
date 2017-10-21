package com.kodilla.jdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();

        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUser() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery =   "SELECT u.*, count(*) AS POST_QTY " +
                "FROM users u, posts p " +
                "WHERE u.ID = p.USER_ID " +
                "GROUP BY u.ID " +
                "HAVING count(*) >= 2 " +
                "ORDER BY u.ID;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            int numberOfPosts = rs.getInt("POST_QTY");
            Assert.assertTrue(numberOfPosts >= 2);

            System.out.println(rs.getInt("ID") + " " + rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME") + ", " + rs.getInt("POST_QTY") + " posts");

            counter++;
        }

        Assert.assertEquals(2, counter);
    }

    @After
    public void newLine() {
        System.out.println();
    }
}
