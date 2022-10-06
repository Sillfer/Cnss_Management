import DB.Database;
import static Helpers.GlobalHelpers.*;
import Helpers.ConsoleForeground;

import java.sql.SQLException;
import java.util.Scanner;

import static DB.Database.resultSet;
import static DB.Database.statement;

public class AgentPage {
    private final static Scanner scan = new Scanner(System.in);
    //Declaration des properties
    private int id_agent;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

    //menu de l'agent
    public static void menuagent() throws SQLException {
        int choice;
        do {
            Print("<1> - Ajouter un dossier");
            Print("<2> - Gerer un dossier");
            Print("<3> - retour au menu principal");
            Print("<4> - pour quitter l'application");
            Print("Choisir svp : ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> newDossier();
//                case 2 ->
                case 3 -> Main.menu();
                case 4 -> {
                    System.out.println("A bientôt !!");
                    System.exit(0);
                }
                default -> System.out.println("plz choisir une autre fois");
            }
        }
        while (true);
    }

    //function qui permet de setter toutes les attributes
    public void NewAgent(int id_agent, String first_name, String last_name, String email, String password) {
        this.id_agent = id_agent;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    //Getters
    public int getId_agent() {
        return id_agent;
    }

    //Setters
    public void setId_agent(int id_agent) {
        this.id_agent = id_agent;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //function qui permet login de l'agent
    public void loginAgent() throws SQLException {
        String message = "Your matricule is : "+genereteMatricule();
        String subject = "Verification code";
        Database.connection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        resultSet = statement.executeQuery("SELECT email,password FROM agent WHERE email = '" + email + "'");
        if (resultSet.next()) {
            if (resultSet.getString("password").equals(password)) {
                System.out.println("Check your email for the code You have 5 minutes to enter the code");
                if (Email.sendEmail(message,subject,"daalabir@gmail.com")) {
                    System.out.println("Login successful");

                    menuagent();
                }
            } else {
                System.out.println("Invalid password");
            }
        } else {
            System.out.println("Invalid email");
        }
        while (true) ;
    }

    //nouveau dossier
    public static void newDossier() throws SQLException {
        while (true){
           Print("Make a choice: ", ConsoleForeground.CYAN);
           Print("1: Add a Dossier", ConsoleForeground.CYAN);
           Scanner scannChoice = new Scanner(System.in);
              int choice = scannChoice.nextInt();
                switch (choice){
                    case 1 -> {
                        DossierPage dossierPage = new DossierPage();
                        int dossierAdded = dossierPage.addDossier();
                        if (dossierAdded == 0){
                            continue;
                        }else{
                            Print("Dossier added successfully", ConsoleForeground.GREEN);
                            break;
                        }
                    }
                    default -> {
                        Print("Invalid choice", ConsoleForeground.RED);
                        Print("Please try again", ConsoleForeground.RED);

                    }
                }

            }
        }
}
