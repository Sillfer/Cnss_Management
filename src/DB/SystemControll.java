package DB;

import DossierPackage.Dossier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.Database.connection;

public class SystemControll {
    public static Double getTotalPriceByTable(String CodeDossier, String TableCnss, String TableDonner,String id_ordonnonce, String id_ordonnonce_cnss) {
        Database.connection();
        try {
            String sql =
                    "SELECT SUM(taux)" + "FROM " + TableCnss + " WHERE " +  id_ordonnonce_cnss  + " =(" + " SELECT " + id_ordonnonce +
                     " FROM " + TableDonner + " WHERE   code_dossier = ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            statement.setString(1, CodeDossier);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
        }


    public void checkDossier(String series) {
//        System.out.println("I am in checkDossier");
        Double MedicamentTotalPrice = getTotalPriceByTable(series, "medicamment", "scan_medicament", "id_medicamment", "medicament_id");
        Double VisiteTotalPrice = getTotalPriceByTable(series, "visit", "dossier", "id_visit", "visit_id");
        Double TotalPrice = MedicamentTotalPrice + VisiteTotalPrice;
        String response = "";
        if (TotalPrice > 1) {
            response = "Accepted";
        } else {
            response = "Rejected";
        }
        Dossier.updateDossier(response, String.valueOf(TotalPrice), series);
    }
}



