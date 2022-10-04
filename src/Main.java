//import the db package
import DB.Database;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        IDandPassword idandPassword = new IDandPassword();
        System.out.println(idandPassword.getLoginInfo());
    }
}

