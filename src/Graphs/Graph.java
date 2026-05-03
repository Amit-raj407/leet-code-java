package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    int V;
    List<List<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // remove for directed
    }

    void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.println(node + " ");

            for(int neighbour : adj.get(node)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }

    void DFS(int node, boolean[] visited) {
        visited[node] = true;
        System.out.println(node + " ");

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour]) {
                DFS(neighbour, visited);
            }
        }
    }

    void traverseAll() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, visited); // or bfs(i)
            }
        }
    }
}
