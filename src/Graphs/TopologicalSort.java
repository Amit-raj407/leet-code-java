package Graphs;

import java.util.List;
import java.util.Stack;

// using DFS
public class TopologicalSort {
    
    private static void dfs(int node, int visited[], Stack<Integer> st, List<List<Integer>> adj) {
        visited[node] = 1;

        for(int it : adj.get(node)) {
            if(visited[it] == 0) {
                dfs(node, visited, st, adj);
            }
        }
        st.push(node);
    }

    static int[] topologicalSort(int V, List<List<Integer>> adj) {
        int visited[] = new int[V];

        Stack<Integer> st = new Stack<Integer>();

        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                dfs(i, visited, st, adj);
            }
        }

        int ans[] = new int[V];

        int i = 0;

        while(!st.empty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }
    

}


// directed Acyclic Graph
/*
linear ordering of vertices such that if
there is an edge between u & v, u appears before v in that ordering
*/

/*
Directed -> only applicable for directed as there is linear ordering here, 1 -> 2,  3 -> 4
Acyclic -> No Cycle
*/

/*

5 -> 0 <- 4
|         |     
>         >
2 -> 3 -> 1

0 -> {}
1 -> {}
2 -> {3}
3 -> {1}
4 -> {0, 1}
5 -> {0, 2}

for(i 0 -> 5)
    if not vis[i] dfs(i)
 
*/