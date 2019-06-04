package models;

import java.util.ArrayList;
import java.util.Date;

public class Node {

    public String uid;
    public String address;
    public Date created;
    public ArrayList<Node> edges;

    public Node(String uid, String address, Date created, ArrayList<Node> edges) {
        this.uid = uid;
        this.address = address;
        this.created = created;
        this.edges = edges;
    }

    public boolean equals(Node node) {
        return (
                this.uid.equals(node.address) &&
                this.address.equals(node.address) &&
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
