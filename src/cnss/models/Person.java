package cnss.models;

public class Person {
    //declaration des properties
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String motdepasse;
    private String role;

    public Person(int id, String nom, String prenom, String email, String motdepasse, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motdepasse = motdepasse;
        this.role = role;
    }

    public Person() {

    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getRole() {
        return role;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
