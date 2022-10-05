import java.sql.SQLException;

public class DossierPage {
    //Declaration des attributes
    private int serie;
    private int totale;
    private String status;
    private String matricule;

    //function qui permet de setter toutes les attributes
    public void newDossier(int serie, int totale, String status, String matricule) {
        this.serie = serie;
        this.totale = totale;
        this.status = status;
        this.matricule = matricule;
    }

    //Getters
    public int getSerie() {
        return serie;
    }
    public int getTotale() {
        return totale;
    }
    public String getStatus() {
        return status;
    }
    public String getMatricule() {
        return matricule;
    }

    //Setters
    public void setSerie(int serie) {
        this.serie = serie;
    }
    public void setTotale(int totale) {
        this.totale = totale;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public static void AddDossier() {
        AgentPage agentPage = new AgentPage();
        agentPage.newDossier();
    }
}
