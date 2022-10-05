import DB.Database;

import java.sql.SQLException;
import java.util.Scanner;

import static DB.Database.resultSet;
import static DB.Database.statement;

public class PatientPage {
    public void loginPatient() throws SQLException {
        {
            Database.connection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Matrix: ");
            String matricule = scanner.nextLine();
            resultSet = statement.executeQuery("SELECT matricule FROM patient WHERE matricule = '" + matricule + "'");
            if (resultSet.next()) {
                if (resultSet.getString("matricule").equals(matricule)) {
                    System.out.println("Welcome " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                }
            }else {
                System.out.println("Matricule incorrect");
            }
        }

    }
}
