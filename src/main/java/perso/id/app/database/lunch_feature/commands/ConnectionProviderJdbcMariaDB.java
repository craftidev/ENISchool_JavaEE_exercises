package perso.id.app.database.lunch_feature.commands;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public abstract class ConnectionProviderJdbcMariaDB {
    private static DataSource dataSource;

    static {
        Context context;

        try {
            String url = "java:comp/env/mariadb/jdbc/pool_connection";
            context = new InitialContext();
            ConnectionProviderJdbcMariaDB.dataSource = (DataSource) context.lookup(url);
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error: can't connect to the database.");
        }
    }

    public static Connection getConnection() throws SQLException {
        return ConnectionProviderJdbcMariaDB.dataSource.getConnection();
    }
}
