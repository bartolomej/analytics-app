package db;

import db.sql.Definition;
import db.sql.Schema;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class Repository {

    private static Connection connection;

    public static void init() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lendit?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "rootPass"
        );
        initDb();
    }

    private static void initDb() throws SQLException {
        Map<Schema, String> definitionStatements = Definition.getAll();
        ArrayList<Schema> initSchemas = getInitTables();
        for (Map.Entry<Schema, String> schema : definitionStatements.entrySet()) {
            if (initSchemas.contains(Schema.valueOf(schema.getValue()))) {
                executeQuery(schema.getValue());
            }
        }
    }

    private static ArrayList<Schema> getInitTables() throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet res = meta.getTables("analytics", null, null, new String[] {"TABLE"});
        ArrayList<Schema> tables = new ArrayList<>();
        while (res.next()) {
            String table = res.getString("TABLE_NAME").toUpperCase();
            tables.add(Schema.valueOf(table));
        }
        return tables;
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        connection.close();
        return resultSet;
    }

    public static void executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        int resultSet = stmt.executeUpdate(query);
        connection.close();
    }

}
