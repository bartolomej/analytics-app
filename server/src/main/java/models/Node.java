package models;

import java.util.ArrayList;
import java.util.Date;

public class Node {

    public String uid;
    public String url;
    public String app;
    public Date created;
    public ArrayList<Node> edges;

    public Node(String uid, String url, String app, Date created, ArrayList<Node> edges) {
        this.uid = uid;
        this.url = url;
        this.created = created;
        this.edges = edges;
    }

    public boolean equals(Node node) {
        return (
                this.uid.equals(node.url) &&
                this.url.equals(node.url) &&
                this.created.toString().equals(node.created.toString()) &&
                this.hasEdges(node.edges)
        );
    }

    public boolean hasEdges(ArrayList<Node> edges) {
        for (Node node : edges) {
            if (!this.edges.contains(node)) return false;
        }
        return true;
    }

    public ArrayList<Node> getNeighbors() {
        return this.edges;
    }

}
