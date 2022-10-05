public class Ordonnance {
    //Declaration des attributes
    private int id_ordonnonce;
    private int serieDossier;
    private int totale_ordonnance;

    ////function qui permet de setter toutes les attributes
    public void newOrdonnance(int id_ordonnonce, int serieDossier, int totale_ordonnance) {
        this.id_ordonnonce = id_ordonnonce;
        this.serieDossier = serieDossier;
        this.totale_ordonnance = totale_ordonnance;
    }

    //Getters
    public int getId_ordonnonce() {
        return id_ordonnonce;
    }
    public int getSerieDossier() {
        return serieDossier;
    }
    public int getTotale_ordonnance() {
        return totale_ordonnance;
    }

    //Setters
    public void setId_ordonnonce(int id_ordonnonce) {
        this.id_ordonnonce = id_ordonnonce;
    }
    public void setSerieDossier(int serieDossier) {
        this.serieDossier = serieDossier;
    }
    public void setTotale_ordonnance(int totale_ordonnance) {
        this.totale_ordonnance = totale_ordonnance;
    }

    public static void AddOrdonnance(){

    }
}
