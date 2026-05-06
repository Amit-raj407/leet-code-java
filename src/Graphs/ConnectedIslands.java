package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedIslands {

    List<Integer> islandSizes(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    int size = dfs(i, j, grid);
                    result.add(size);
                }
            }
        }
        return result;
    }

    int maxIslandSize(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;

         for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    int size = dfs(i, j, grid);
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    int dfs(int row, int col, char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        if(row < 0 || col < 0 || row >= r || col >= c || grid[row][col] == '0')
            return 0;

        grid[r][c] = '0';
        int count = 1;

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++) {
            count += dfs(r + drow[i], c + dcol[i], grid);
        }

        return count;
    }
    
}