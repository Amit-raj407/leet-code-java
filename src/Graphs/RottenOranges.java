package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;

    }
}

public class RottenOranges {
    public int minTimeForRottingOranges(int [][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[row][col];

        int cntFresh = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }

                if(grid[i][j] == 1) cntFresh++;
            }
        }


        int time = 0;

        // UP, DOWN, LEFT, RIGHT
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;

            time = Math.max(time, t);
            q.remove();

            for(int i = 0; i < 4; i++) {
                int nRow = r + drow[i];
                int nCol = c + dcol[i];

                if(nRow >=0 && nRow < row && nCol >=0 && nCol < col
                    && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1
                ) {
                    q.add(new Pair(nRow, nCol, t + 1));
                    visited[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }

        if(cnt != cntFresh) return -1;
        return time;
    }
}

// Algo - BFS as this traverses level wise, at each second rot one level and we need minimum time
/*
Put all rotten oranges in queue, then start putting their neighbours
We can have a visited matrix -> mark rottens
*/

// 0 - Empty
// 1 - Fresh
// 2 - Rotten

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange.
// If this is impossible, return -1.

// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.



// 2 1 1
// 1 1 0   f(0)
// 0 1 1

// 2 2 1
// 2 1 0   f(1)
// 0 1 1

// 2 2 2
// 2 2 0   f(2)
// 0 1 1

// 2 2 2
// 2 2 0   f(3)
// 0 2 1

// 2 2 2
// 2 2 0   f(4)
// 0 2 2

// total time required - 4

// one rotten orange (i,j) will rotten oranges at (i-1, j), (i+1, j), (i, j-1), (i, j+1)