package models;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public boolean contains(Node node) {
        return this.nodes.contains(node);
    }


}
