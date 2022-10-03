import java.sql.SQLException;
import java.util.HashMap;
import DB.Database;

import static DB.Database.SelectAdmin;

public class IDandPassword {
    HashMap<String, String> logininfo = new HashMap<String, String>();
    IDandPassword() throws SQLException {
        logininfo.get(Database.SelectAdmin().toString());

    }
    protected HashMap getLoginInfo() {
        return logininfo;
    }
}
