package DB;

import java.sql.*;
import java.util.Scanner;

public class Database {
    public static void login(){


try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cnss_jdbc", "root", "?!LoneCrow?!");
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM admin WHERE email = '" + email + "' AND password = '" + password + "'");

        if (resultSet.next()) {
            if (resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
                System.out.println("Welcome " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            } else {
                System.out.println("Invalid email or password");
            }
        }
    }
    catch (SQLException e) {
        e.printStackTrace();
    }

}

    }



