package DB;

import java.sql.*;
import java.util.HashMap;

public class Database {

    public static void main(String[] args ) throws SQLException {

// call back the SelectAdmin method
        SelectAdmin();


    }

    public static Object SelectAdmin() throws SQLException {

        // create a connection to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cnss_jdbc", "root", "?!LoneCrow?!");

        // create a statement
        Statement stmt = conn.createStatement();

        // execute the query checking for the admin
        ResultSet rs = stmt.executeQuery("SELECT * FROM admin");
        HashMap<String, String> logininfo = new HashMap<String, String>();
        ResultSet rr = stmt.executeQuery("INSERT INTO admin VALUES (firstname, lastname, email, password)");

        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getString("first_name") + "\t" +
                    rs.getString("last_name"));
        }
        while (rr.next()) {
            logininfo.put(rr.getString("firstname"), rr.getString("lastname"));
        }
        return null;
    }
}

