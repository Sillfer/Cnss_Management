import DB.Database;
import DossierPackage.Dossier;
import DossierPackage.Visite;

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
        int chose;
        do {
            System.out.println("<1> - Ajouter un dossier");
            System.out.println("<2> - retour au menu principal");
            System.out.println("<3> - pour quitter l'application");
            System.out.print("Choisir svp : ");
            chose = scan.nextInt();
            switch (chose) {
                case 1 -> newDossier();
                case 2 -> Main.menu();
                case 3 -> {
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
        Database.connection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        resultSet = statement.executeQuery("SELECT email,password FROM agent WHERE email = '" + email + "'");
        if (resultSet.next()) {
            if (resultSet.getString("password").equals(password)) {
                menuagent();
            } else {
                System.out.println("Invalid password");
            }
        } else {
            System.out.println("Invalid email");
        }
        while(true);
    }

    //nouveau dossier
    public static void newDossier() throws SQLException {
        int chose;
        do {

            System.out.println("<1> - Ajouter un visite");
            System.out.println("<2> - Ajouter un medicamment");
            System.out.println("<3> - Valider le dossier");
            System.out.println("<4> - retour au menu principal");
            System.out.print("Choisir svp : ");
            chose = scan.nextInt();
            switch (chose) {
//                case 1 ->
                case 5 -> menuagent();
                default -> System.out.println("plz choisir une autre fois");
            }
        }
        while (true);
    }
}
