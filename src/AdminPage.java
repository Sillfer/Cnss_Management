import DB.Database;

import java.sql.SQLException;
import java.util.Scanner;

import static DB.Database.resultSet;
import static DB.Database.statement;

public class AdminPage {
    public void loginAdmin() throws SQLException {
        Database.connection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        resultSet = statement.executeQuery("SELECT * FROM admin WHERE email = '" + email + "' AND password = '" + password + "'");
        if (resultSet.next()) {
            if (resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
                System.out.println("Welcome " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            } else if (!resultSet.getString("email").equals(email)) {
                System.out.println("Invalid email");
            }else if (!resultSet.getString("password").equals(password)) {
                System.out.println("Invalid password");
            }

        }
    }
}

