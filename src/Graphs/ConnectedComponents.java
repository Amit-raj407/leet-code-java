package Graphs;

import java.util.List;

public class ConnectedComponents {

    int countConnectedComponents(int V, List<List<Integer>> adj) {
        int count = 0;
        boolean visited[] = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFS(i, visited, adj);
                count++;
            }
        }

        return count;
    }

    void DFS(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        System.out.println(node + " ");

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour]) {
                DFS(neighbour, visited, adj);
            }
        }
    }

    
}