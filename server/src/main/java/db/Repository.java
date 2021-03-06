package db;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.result.Field;
import config.DbConstants;
import db.sql.Definition;
import db.sql.Delete;
import db.sql.Schema;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static Connection connection;

    public static void init() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:" + DbConstants.host + "/" + DbConstants.database + "?" +
                        "useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                        "&useLegacyDatetimeCode=false&serverTimezone=UTC",
                DbConstants.user, DbConstants.password
        );
    }

    private static void initDb() throws Exception {
        Map<Schema, String> definitionStatements = Definition.getAll();
        ArrayList<Schema> initSchemas = getInitTables();
        for (Map.Entry<Schema, String> schema : definitionStatements.entrySet()) {
            if (initSchemas.contains(schema.getKey())) {
                executeUpdate(schema.getValue());
            }
        }
    }

    private static ArrayList<Schema> getInitTables() throws Exception {
        if (connection == null) throw new Exception("Db not initialized");
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet results = meta.getTables("analytics", null, null, new String[] {"TABLE"});
        ArrayList<Schema> tables = new ArrayList<>();
        while (results.next()) {
            String table = results.getString("TABLE_NAME").toUpperCase();
            tables.add(Schema.valueOf(table));
        }
        return tables;
    }

    public static ArrayList<Map> executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        ArrayList<Map> results = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> columns = new HashMap<>();
            Field[] fields = ((ResultSetImpl)resultSet).getColumnDefinition().getFields();
            for (Field field : fields) {
                String label = field.getColumnLabel();
                columns.put(label, resultSet.getString(label));
            }
            results.add(columns);
        }
        return results;
    }

    public static void executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        int resultSet = stmt.executeUpdate(query);
    }

    public static void executeManipulation(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        boolean resultSet = stmt.execute(query);
    }

    public static void purgeDatabase() throws SQLException {
        executeManipulation(Delete.allAppOwnership());
        executeManipulation(Delete.allUsers());
        executeManipulation(Delete.allLogs());
        executeManipulation(Delete.allAdmins());
        executeManipulation(Delete.allGraphRelations());
        executeManipulation(Delete.allNodes());
        executeManipulation(Delete.allApps());
    }

}
