package lesson20240703;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {

    public Connection makeConnection () throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String name = bundle.getString("db.name");
        String password = bundle.getString("db.password");
        String user = bundle.getString("db.user");
        return DriverManager.getConnection(url + "/" + name, user, password);
    }
}
