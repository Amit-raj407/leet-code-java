package Graphs;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if(index == word.length()) {
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length 
            || col >= board[0].length 
            || board[row][col] != word.charAt(index))
            return false;

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
            dfs(board, word, row + 1, col, index + 1) ||
            dfs(board, word, row - 1, col, index + 1) ||
            dfs(board, word, row, col + 1, index + 1) ||
            dfs(board, word, row, col - 1, index + 1);

        board[row][col] = temp;
        return found;

    }
}


/*

1. Word Search (LeetCode 79)
Problem

Given a 2D board of characters and a word, determine if the word exists in the grid.

You can move:

Up
Down
Left
Right

You cannot reuse the same cell in one path.

Example:

Board

A B C E
S F C S
A D E E

Word = "ABCCED"

Answer = true

Path:

A → B → C
        ↓
C ← E ← D
Pattern

This is a Backtracking + DFS problem.

Think:

Start from every cell.

If first character matches

    DFS in 4 directions

        If next character matches

             Continue

        Else

             Backtrack
Time Complexity
O(M * N * 4^L)

M = rows
N = columns
L = word length
*/