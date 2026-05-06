package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int node, parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class CycleDetectionUndirectedBFS {
    static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean bfs(int start, boolean[] visited, List<List<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int parent = p.parent;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new Pair(neighbor, node));
                } else if (neighbor != parent) {
                    return true; // cycle detected
                }
            }
        }

        return false;
    }
}
