//import the db package
//import DB.Database;


import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;
//import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        LoginPage loginAdmin = new LoginPage();
        LoginPage loginAgent = new LoginPage();
        LoginPage loginPatient = new LoginPage();
        Timer timer = new Timer(true);

        int choice = -1;
        do {
            System.out.println("---------- Main Menu ----------");
            System.out.println("1: Connect as an admin");
            System.out.println("2: Connect as a agent");
            System.out.println("3: Connect as a patient");
            System.out.println("4: Quit");
            choice = ReadInt("Please choose an option : ");
            switch (choice) {
                case 1 -> loginAdmin.adminLogin();
                case 2 -> loginAgent.agentLogin();
                case 3 -> loginPatient.patientLogin();
            }
        }while (choice!=4);
        timer.cancel();
    }
    static int ReadInt(String Message) {
        boolean error=false;
        do {
            error=false;
            try {
                System.out.println(Message);
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("Value entered is not valid.");
                error=true;
            }
        }while (error);
        return -1;
    }

    public static String randomAlphaNumeric(int i) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(i);
        for (int j = 0; j < i; j++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}

