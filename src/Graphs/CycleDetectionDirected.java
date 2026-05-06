package Graphs;

import java.util.List;

public class CycleDetectionDirected {
    boolean isCycle(int V, List<List<Integer>> adj) {

        boolean visited[] = new boolean[V];
        boolean pathVisited[] = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, visited, pathVisited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {
        visited[node] = true;
        pathVisited[node] = true;

        for(int neighbour: adj.get(node)) {
            if(!visited[neighbour]) {
                if(dfs(neighbour, visited, pathVisited, adj)) {
                    return true;
                }
            } else if(pathVisited[neighbour]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}

/*
In undirected:
👉 we used parent

In directed:
👉 edges are one-way

So this:

0 → 1 → 2
     ↑   ↓
     ← ←

There is no “parent” concept like before

🔥 Core Idea (VERY IMPORTANT)

👉 A cycle exists if:

You revisit a node that is already in the current DFS path
*/