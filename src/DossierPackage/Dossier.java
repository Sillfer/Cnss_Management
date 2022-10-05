package DossierPackage;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import static DB.Database.connection;

public class Dossier {
    private static String serie;
    private int totale;
    private String response;
    private String status;
    private String matricule;
    public Dossier(String serie, String status, String response, String matricule) {
        this.serie = serie;
//        this.totale = totale;
        this.status = status;
        this.response = response;
        this.matricule = matricule;
    }

    //Getters
    public static String getSerie() {
        return serie;
    }
    public int getTotale() {
        return totale;
    }
    public String getResponse() {
        return response;
    }

    public String getStatus() {
        return status;
    }
    public String getMatricule() {
        return matricule;
    }

    //Setters
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public void setTotale(int totale) {
        this.totale = totale;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public Boolean CreateDossier(ArrayList<Medicamment> medicaments, ArrayList<Visite> visites)
    {
        boolean result = true;
        try{
            if(!visites.isEmpty()){
                connection();
                PreparedStatement ps = connection.prepareStatement("INSERT INTO dossier (serie, totale, status, matricule) VALUES (?,?,?,?)");
                connection.setAutoCommit(false);
                ps.setString(1, serie);
                ps.setInt(2, totale);
                ps.setString(3, status);
                ps.setString(4, matricule);
                result = ps.execute();
                connection.commit();
                ps.close();
                connection.close();

                for (Visite v : visites) {
                    v.AddVisite();
                }
                if (!medicaments.isEmpty()) {
                    for (Medicamment m : medicaments) {
                        m.AddMedicamment();
                    }
                }

            }else {
                System.out.println("There has to be at least one visit");
            }
        }
        catch (Exception e){
            result = false;
        }

        return result;
    }
}
