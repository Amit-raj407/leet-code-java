package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kahn's Algo
public class TopoSortBFS {

    static int[] topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];

        for(int i = 0; i < V; i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int i = 0;

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            topo[i++] = node;

            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }
    
}

/*

InDegree - number of incoming edges
For the below example

0 - 2
1 - 2
2 - 1
3 - 1
4 - 0
5 - 0

steps
calculate InDegree for all nodes
insert all nodes with InDegree 0
here 4 and 5 added to Queue

for 4 get all neighbors, remove 4 from graph\
then indegree changes
0 - 1
1 - 1
2 - 1
3 - 1
4 - 0
5 - 0

Then remove 5 from graph
0 - 0
1 - 1
2 - 0
3 - 1
4 - 0
5 - 0

now in queue I will have 4 5 0 2
0 does not have connections
2 has 1 connection, remove from Graph
0 - 0
1 - 1
2 - 0
3 - 0
4 - 0
5 - 0
now in queue I will have 4 5 0 2 3
remove 3 from graph
0 - 0
1 - 0
2 - 0
3 - 0
4 - 0
5 - 0

Queue - 4 5 0 2 3 1




*/

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