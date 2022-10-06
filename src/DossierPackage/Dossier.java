package DossierPackage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static DB.Database.connection;
import static Helpers.GlobalHelpers.Print;

public class Dossier {
    private static String series;
    private String statut;
    private String response;
    private String matricule;

    public Dossier(String series, String statut, String response, String matricule) {
        Dossier.series = series;
        this.statut = statut;
        this.response = response;
        this.matricule = matricule;
    }

    //Getters
    public static String getSerie() {
        return series;
    }

    //Setters
    public void setSerie(String serie) {
        series = serie;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return statut;
    }

    public void setStatus(String status) {
        this.statut = status;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Boolean CreateDossier(ArrayList<Medicamment> medicaments, ArrayList<Visite> visites) {
        boolean result = true;
        try {
            if (!visites.isEmpty()) {
                connection();
                PreparedStatement ps = connection.prepareStatement("INSERT INTO dossier (series, statut, response, matricule,total) VALUES (?,?,?,?,?)");
                connection.setAutoCommit(false);
                ps.setString(1, series);
                ps.setString(2, this.statut);
                ps.setString(3, this.response);
                ps.setString(4, this.matricule);
                ps.setString(5, null);
                result = ps.execute();
//                Print("I am here");
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

            } else {
                System.out.println("There has to be at least one visit");
            }
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public void  getAllDossier(String statut) {
        ArrayList dossiers = new ArrayList<>();
        try {
            connection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM dossier WHERE statut = ?");
            connection.setAutoCommit(false);
            ps.setString(1, statut);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Print(series);
                dossiers.add(new DossierStatut(rs.getString("series"), rs.getString("statut"), rs.getString("response"), rs.getString("matricule")));
            }
            Print(String.valueOf(dossiers));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateDossier(String response, String total, String series) {
        try {
            connection();
            PreparedStatement ps = connection.prepareStatement("UPDATE dossier SET response = ? , total = ?, series = ?  WHERE series = ?");
            connection.setAutoCommit(false);
            ps.setString(1, response);
            ps.setString(2, total);
            ps.setString(3, series);
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
