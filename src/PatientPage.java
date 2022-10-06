import DB.Database;

import java.sql.SQLException;
import java.util.Scanner;

import static DB.Database.resultSet;
import static DB.Database.statement;

public class PatientPage {
    private final static Scanner scan = new Scanner(System.in);
    public void loginPatient() throws SQLException {
        {
            Database.connection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Matricule : ");
            String matricule = scanner.nextLine();
            resultSet = statement.executeQuery("SELECT matricule FROM patient WHERE matricule = '" + matricule + "'");
            if (resultSet.next()) {
                if (resultSet.getString("matricule").equals(matricule)) {
                    System.out.println("Welcome " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                    System.out.println("Welcome to your profile");
                    menupatient();
                }
            }else {
                System.out.println("Matricule incorrect");
            }
        }
    }

    public static void menupatient() throws SQLException {
        int chose;
        do {
            System.out.println("<1> - Voir l'historique de dossier");
            System.out.println("<2> - retour au menu principal");
            System.out.print("Choisir svp : ");
            chose = scan.nextInt();
            switch (chose) {
                case 1 -> VoirHistorique();
                case 2 -> Main.menu();
                default -> System.out.println("plz choisir une autre fois");
            }
        }
        while (true);
    }

    public static void VoirHistorique() throws SQLException {
        System.out.println("Historique de dossier");
    }
}
