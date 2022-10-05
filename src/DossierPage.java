import java.sql.PreparedStatement;
import java.util.ArrayList;

import DossierPackage.Dossier;
import DossierPackage.Medicamment;
import DossierPackage.Visite;
import Helpers.GlobalHelpers;

import static DB.Database.connection;

public class DossierPage {

    ArrayList<String> medicaments = new ArrayList<String>();
    ArrayList<String> visites = new ArrayList<String>();
    //Declaration des attributes

    public Boolean AddDossier(String matricule, ArrayList<String> medicaments,ArrayList<String> visites){
        ArrayList<Medicamment> medicamentsList = new ArrayList<>();
        ArrayList<Visite> visitesList = new ArrayList<>();
        Dossier dossier = new Dossier(GlobalHelpers.genereteMatricule(),"En Attente","En Attente",matricule);
        for (String Visite:visites) {
            Visite visite = new Visite(GlobalHelpers.genereteMatricule(),Visite,Dossier.getSerie());
            visitesList.add(visite);
        }
        for (String Medicamment:medicaments) {
            Medicamment medicamment = new Medicamment(Medicamment,Dossier.getSerie());
            medicamentsList.add(medicamment);
        }

        return dossier.CreateDossier(medicamentsList,visitesList);
    }
}


