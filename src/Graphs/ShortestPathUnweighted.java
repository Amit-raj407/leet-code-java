package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnweighted {
    
    void shortestPath(int start, int V, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();

        int[] dist = new int[V];

        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int neighbour: adj.get(node)) {
                if(dist[neighbour] == -1) {
                    dist[neighbour] = dist[node] + 1;
                    q.add(neighbour);
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
