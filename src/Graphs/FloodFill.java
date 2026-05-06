package Graphs;

public class FloodFill {
    void floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];

        int row = image.length;
        int col = image[0].length;

        boolean[][] visited = new boolean[row][col];

        dfs(sr, sc, image, visited, original, newColor);
    }

    void dfs(int r, int c, int[][] image, boolean[][] visited, int original, int newColor) {
        int row = image.length;
        int col = image[0].length;

        if(r < 0 || r >= row || c < 0 || c >= col) return;

        if(visited[r][c] || image[r][c] != original) return;

        visited[r][c] = true;
        image[r][c] = newColor;

        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++) {
            dfs(r + drow[i], c + dcol[i], image, visited, original, newColor);
        }

    }
}
