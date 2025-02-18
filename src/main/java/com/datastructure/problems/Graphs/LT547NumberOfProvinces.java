package com.datastructure.problems.Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 *  TC: O(N) + O(V + 2E)
 *  SC: O(N) + O(N) + O(N) ~= O(3N)
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class LT547NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        int col = isConnected[0].length;
        boolean[] visited = new boolean[row];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < row; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < row; i++) {
            for(int j = 0 ; j < col; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int count = 0;
        for(int i =0 ; i < visited.length; i++) {
            if(!visited[i]) {
                count++;
                dfs(i,adjList,visited);
            }
        }

        return count;
    }

    void dfs(int node, List<List<Integer>> adj,boolean[] visited) {
        visited[node] = true;
        for(int depthNode : adj.get(node)) {
            if(!visited[depthNode]){
                dfs(depthNode,adj,visited);
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,0},{1,1,0},{0,0,1}};
        var lt = new LT547NumberOfProvinces();
        System.out.println(lt.findCircleNum(matrix));
    }

}
