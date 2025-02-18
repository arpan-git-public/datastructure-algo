package com.datastructure.problems.Graphs;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 *
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *
 * Explanation:
 *
 *
 * In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
 *
 * Example 2:
 *
 * Input: board = [["X"]]
 *
 * Output: [["X"]]
 *
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class LT130SurroundedRegions {
    int[][] DIRECTION = {
            {0,-1},
            {0,1},
            {-1,0},
            {1,0}
    };
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i =0; i < n ; i++) {
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(i,0,n,m,board,visited);
            }
            if(!visited[i][m-1] && board[i][m-1] == 'O'){
                dfs(i,m-1,n,m,board,visited);
            }
        }
        for(int i =0; i < n ; i++) {
            if(!visited[0][i] && board[0][i] == 'O'){
                dfs(0,i,n,m,board,visited);
            }
            if(!visited[n-1][i] && board[n-1][i] == 'O'){
                dfs(n-1,i,n,m,board,visited);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, int n, int m, char[][] board, boolean[][] visited) {
        if(i < 0 || j< 0 || i >= n || j >= m || visited[i][j] || board[i][j] == 'X')
             return;

        visited[i][j] = true;

        Arrays.stream(DIRECTION).forEach(d -> {
            dfs(i+d[0],j+d[1],n, m, board,visited);
        });
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
      //  char[][] board = {{'O'}};
        var lt = new LT130SurroundedRegions();
        lt.solve(board);
        IntStream.range(0,board.length).forEach(row -> {
            System.out.println();
            IntStream.range(0,board[0].length).forEach(col -> {
                System.out.print(board[row][col] + " ");
            });
        });
    }
}
