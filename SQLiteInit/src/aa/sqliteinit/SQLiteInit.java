/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.sqliteinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aanciaes
 */
public class SQLiteInit {

    static String databaseFile;
    static Connection connection = null;

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {

        databaseFile = "sampleCRUD.db";

        String jdbcConnStr = "jdbc:sqlite:/opt/sqlite/data/" + databaseFile;

        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        try {

            System.out.println("jdbc coonection String: " + jdbcConnStr);
            // create a database connection
            connection = DriverManager.getConnection(jdbcConnStr);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec. 

            // Creating table for System Parameters
            createSysParamTable();
            dumpSysParamTable();

        } catch (SQLException e) {
            // if the error message is "out of memory", 
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

    private static void createSysParamTable() {
        try {
            System.out.println("Creating ID table ....");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("create table SystemParameter (key text, value text)");

            System.out.println("Inserting ....");
            statement.executeUpdate("insert into SystemParameter values ('db.name', '" + databaseFile + "')");

        } catch (SQLException ex) {
            Logger.getLogger(SQLiteInit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void dumpSysParamTable() {
        try {
            System.out.println("Selecting ....");
            
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            ResultSet rs = statement.executeQuery("select * from SystemParameter");
            while (rs.next()) {
                System.out.println("key[" + rs.getString("key") + "] value[" + rs.getString("value") + "]" );
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLiteInit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
