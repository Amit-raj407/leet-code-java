package Graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphDS {
    int V;
    List<List<Integer>> adj;

    GraphDS(int v) {
        this.V = v;
        adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
