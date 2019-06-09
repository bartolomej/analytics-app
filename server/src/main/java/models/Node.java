package models;

import java.util.ArrayList;
import java.util.Date;

public class Node {

    public String uid;
    public String url;
    public String app;
    public Date created;
    public ArrayList<String> edges;

    public Node(String uid, String url, String app, Date created, ArrayList<String> edges) {
        this.uid = uid;
        this.url = url;
        this.created = created;
        this.edges = new ArrayList<>();
    }

    public boolean equals(Node node) {
        return (
                this.uid.equals(node.url) &&
                this.url.equals(node.url) &&
                this.created.toString().equals(node.created.toString()) &&
                this.hasEdges(node.edges)
        );
    }

    public void addEdges(ArrayList<String> edges) {
        this.edges.addAll(edges);
    }

    public boolean hasEdges(ArrayList<String> edges) {
        for (String node : edges) {
            if (!this.edges.contains(node)) return false;
        }
        return true;
    }

    public boolean hasEdge(String edge)  {
        return this.edges.contains(edge);
    }

    public ArrayList<String> getEdges() {
        return this.edges;
    }

}
