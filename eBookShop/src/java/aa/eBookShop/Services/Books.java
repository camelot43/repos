/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.eBookShop.Services;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 *
 * @author aanciaes
 */
public class Books {

    static final Logger LOGGER = Logger.getLogger(Books.class);

    DataSource pool; // Database connection pool

    List<book> results = new ArrayList();

    public Books() {

        LOGGER.info("Books Constructor: init pool");
        try {
            // Create a JNDI Initial context to be able to lookup the DataSource
            InitialContext ctx = new InitialContext();
            // Lookup the DataSource, which will be backed by a pool
            // that the application server provides.
            pool = (DataSource) ctx.lookup("java:comp/env/jdbc/ebookshop");
            if (pool == null) {
                // throw new Exception("Unknown DataSource 'jdbc/ebookshop'");
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    public void query(String title, String author) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Get a connection from the pool
            conn = pool.getConnection();

            // Step 2: Create a "Statement" object inside the "Connection"
            stmt = conn.createStatement();

            String sqlStr = "SELECT * FROM books WHERE ";

            if (!title.isEmpty()) {
                sqlStr += "title like '%" + title + "%'";
                if (!author.isEmpty()) {
                    sqlStr += " AND ";
                }
            }

            if (!author.isEmpty()) {
                sqlStr += "author like '%" + author + "%'";
            }

            sqlStr += " ORDER BY author ASC, title ASC";

            LOGGER.info(sqlStr);

            ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the

            // Step 4: Process the query result
            while (rset.next()) {
                book b = new book(
                        rset.getInt("id"),
                        rset.getString("title"),
                        rset.getString("author"),
                        rset.getDouble("price"),
                        rset.getInt("qty"));
                results.add(b);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // Step 5: Close the Statement and Connection
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }


    public List<book> getResult() {
        return results;
    } 
    
    
    public void dumpResults() {
        int i = 0;

        LOGGER.info("Number of elements:" + results.size());
        while (i < results.size()) {
            book b = (book) results.get(i);
            LOGGER.info(i
                    + ":" + b.getId()
                    + "|" + b.getTitle()
                    + "|" + b.getAuthor()
                    + "|" + b.getPrice()
                    + "|" + b.getQty()
            );
            ++i;
        }
    }

}
