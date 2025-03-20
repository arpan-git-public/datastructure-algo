package com.datastructure.problems.DP;

import java.util.Arrays;

public class CherryPick {
    int totalCherryPickUp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] position = new int[m][n];
        Arrays.stream(position).forEach(a -> Arrays.fill(a,-1));
       int aliceCount = calculateChocolatePick(0,0,grid,position);
       Arrays.stream(position).forEach(x-> {
           System.out.println();
           Arrays.stream(x).forEach(y-> System.out.print(y + "  "));
       });
       int bobCount = calculateChocolatePick(0,n-1,grid,position);
        System.out.println("After Bob count : ");
        Arrays.stream(position).forEach(x-> {
            System.out.println();
            Arrays.stream(x).forEach(y-> System.out.print(y + "  "));
        });
        System.out.println();
        System.out.println(aliceCount);
        System.out.println(bobCount);
       return aliceCount + bobCount;
    }

    private int calculateChocolatePick(int i, int j, int[][] grid, int[][] position) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return 0;
        }
        if(position[i][j] > 0) return 0;
        if(i == grid.length - 1) return grid[i][j];

        int down = calculateChocolatePick(i+1,j,grid,position);
        int leftDown = calculateChocolatePick(i+1,j-1,grid,position);
        int rightDown = calculateChocolatePick(i+1, j+1, grid, position);

        return position[i][j] = grid[i][j] + Math.max(down, Math.max(leftDown,rightDown));
    }

    public static void main(String[] args) {
        int[][] grid = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        var lt = new CherryPick();
        System.out.println(lt.totalCherryPickUp(grid));
    }
}
