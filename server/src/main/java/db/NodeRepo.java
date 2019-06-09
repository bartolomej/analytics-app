package db;

import db.sql.Insert;
import db.sql.Select;
import models.Log;
import models.Node;
import utils.ParseUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static db.Repository.executeManipulation;
import static db.Repository.executeQuery;

public class NodeRepo {

    public static void add(Node node) throws SQLException {
        executeManipulation(Insert.node(node));
    }

    public static void addEdge(String from, String to) throws SQLException {
        executeManipulation(Insert.graphRelation(from, to)); // TODO: query node with relations
    }

    public static ArrayList<Node> getByApp(String appName) throws SQLException {
        ArrayList<Node> nodes = deserializeResults(executeQuery(Select.appNodes(appName)));
        for (Node node : nodes) {
            node.addEdges(deserializeEdges(executeQuery(Select.nodeEdges(node.uid))));
        }
        return nodes;
    }

    public static ArrayList<Node> getAll() throws SQLException {
        ArrayList<Node> nodes = deserializeResults(executeQuery(Select.allNodes()));
        for (Node node : nodes) {
            node.addEdges(deserializeEdges(executeQuery(Select.nodeEdges(node.uid))));
        }
        return nodes;
    }

    private static ArrayList<Node> deserializeResults(ArrayList<Map> results) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (Map entry : results) {
            nodes.add(deserializeNode(entry));
        }
        return nodes;
    }

    private static Node deserializeNode(Map entry) {
        Date created = ParseUtil.toJavaDate((String)entry.get("created"));
        return new Node(
                (String)entry.get("uid"),
                (String)entry.get("url"),
                (String)entry.get("app"),
                created,
                null
        );
    }

    private static ArrayList<String> deserializeEdges(ArrayList<Map> results) {
        ArrayList<String> edges = new ArrayList<>();
        for (Map entry : results) {
            edges.add((String)entry.get("to_node")); // TODO: add Edge class ?
        }
        return edges;
    }
}
