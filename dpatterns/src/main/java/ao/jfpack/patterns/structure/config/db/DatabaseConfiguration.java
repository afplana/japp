package ao.jfpack.patterns.structure.config.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConfiguration {

    protected Connection connection;

    private DatabaseConfiguration() {}

    private DatabaseConfiguration(String url, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    protected static DatabaseConfiguration from(String url, String user, String password) throws SQLException {
        return new DatabaseConfiguration( url, user, password);
    }

    protected  Connection configure(String url, String user, String password) throws SQLException {
        return connection;
    }

    protected Optional<ResultSet> executeQuery(String query) throws SQLException {
        return Optional.ofNullable(connection.prepareStatement(query).executeQuery());
    }

    protected void closeConnection() throws SQLException {
        this.connection.close();
    }
}
