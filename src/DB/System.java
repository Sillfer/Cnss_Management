package DB;
import DossierPackage.Dossier;

import java.sql.*;
import static DB.Database.connection;

public class System {
    public static Double getTotalPriceByTable(String CodeDossier,String TableCnss,String TableDonner ) {
    Database.connection();
        try{
            String sql = "SELECT SUM(total)"+"FROM "+ TableCnss + "WHERE series=(SELECT series "
                    +"FROM "+TableDonner+"WHERE code_dossier=?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            statement.setString(1,CodeDossier);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void checkDossier(String series){
        Double MedicamentTotalPrice = getTotalPriceByTable(series,"medicamment","dossier");
        Double VisiteTotalPrice = getTotalPriceByTable(series,"visit","dossier");
        Double TotalPrice = MedicamentTotalPrice + VisiteTotalPrice;
        String response = "";
        if(TotalPrice > 0){
            response = "Accepted";
    }else {
            response = "Rejected";
        }
        Dossier.updateDossier(response,String.valueOf(TotalPrice),series);
    }
}

