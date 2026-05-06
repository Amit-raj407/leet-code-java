package Graphs;

import java.util.List;

public class CycleDetectionUndirected {
    boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[V]) {
                if(dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for(int neighbour: adj.get(node)) {
            if(!visited[neighbour]) {
                if(dfs(neighbour, node, visited, adj)) {
                    return true;
                }
            } else if(neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}

/*
1. Problem
👉 Given an undirected graph, detect if it contains a cycle

👉 If you visit a node that is already visited AND not your parent
💥 → Cycle detected
*/