public class Visite {
    //Declaration des attributes
    private int id_visite;
    private int ordonnance_id;
    private String medecinType;
    private String taux;

    ////function qui permet de setter toutes les attributes
    public void newVisite(int id_visite, int ordonnance_id, String medecinType, String taux) {
        this.id_visite = id_visite;
        this.ordonnance_id = ordonnance_id;
        this.taux = taux;
    }

    //Getters
    public int getId_visite() {
        return id_visite;
    }
    public int getOrdonnance_id() {
        return ordonnance_id;
    }
    public String getMedecinType() {
        return medecinType;
    }
    public String getTaux() {
        return taux;
    }

    //Setters
    public void setId_visite(int id_visite) {
        this.id_visite = id_visite;
    }
    public void setOrdonnance_id(int ordonnance_id) {
        this.ordonnance_id = ordonnance_id;
    }
    public void setMedecinType(String medecinType) {
        this.medecinType = medecinType;
    }
    public void setTaux(String taux) {
        this.taux = taux;
    }

    public static void AddVisite(){

    }
}
