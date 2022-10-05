public class Medicamment {
    //Declaration des attributes
    private int id_medicamment;
    private int ordonnance_id;
    private String name;
    private Double taux;

    ////function qui permet de setter toutes les attributes
    public void newMedicamment(int id_medicamment, int ordonnance_id, String name, Double taux) {
        this.id_medicamment = id_medicamment;
        this.ordonnance_id = ordonnance_id;
        this.name = name;
        this.taux = taux;
    }

    //Getters
    public int getId_medicamment() {
        return id_medicamment;
    }
    public int getOrdonnance_id() {
        return ordonnance_id;
    }
    public String getName() {
        return name;
    }
    public Double getTaux() {
        return taux;
    }

    //Setters

    public void setId_medicamment(int id_medicamment) {
        this.id_medicamment = id_medicamment;
    }
    public void setOrdonnance_id(int ordonnance_id) {
        this.ordonnance_id = ordonnance_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public static void AddMedicamment(){

    }
}
