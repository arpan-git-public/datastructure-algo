package com.datastructure.problems.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity,
 * you have a knight at square [0, 0].
 * <p>
 * A knight has 8 possible moves it can make, as illustrated below.
 * Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * Example 2:
 * <p>
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 */
public class LT1197MinimumKnightMoves {


    public int minKnightMoves(int x, int y) {
        int[][] moves = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {1, -2}, {-1, -2}, {-2, -1}, {2, -1}};
        int[][] visited = new int[601][601];
        int level = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {300, 300};

        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] node = queue.poll();

                if (node[0] == x+300 && node[1] == y+300) {
                    return level;
                }
                //iterate over all choices and push to queue if not visited
                for (int i = 0; i < moves.length; i++) {
                    int row = node[0] + moves[i][0];
                    int col = node[1] + moves[i][1];
                    if (row >= 0 && row < 601 && col >= 0 && col < 601 && visited[row][col] == 0) {
                        visited[row][col] = 1;
                        int[] pair = {row, col};
                        queue.add(pair);
                    }
                }
                size--;
            }
            level++;
        }
        return -2;
    }

    public static void main(String[] args) {
        var obj = new LT1197MinimumKnightMoves();
        System.out.println(obj.minKnightMoves(1, 1));
    }
}
