package com.datastructure.problems.Graphs;

import java.util.*;

public class LT785IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        //create adjList
        //BFS and check current and neighbours color if matches then return false.
        // do it for all components.

        List<List<Integer>> adjList = new ArrayList<>();
        int[] colors = new int[graph.length];
        for(int i = 0 ; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        int i = 0;
        for(int[] edge : graph) {
            for(int node : edge) {
                adjList.get(i).add(node);
            }
            i++;
        }
        Arrays.fill(colors, -1);

        for(int j = 0 ; j< colors.length ; j++) {
            if(colors[j] == -1) {
                if(!isCheckBFSForBipartite(j, colors, adjList)) return false;
            }
        }
        return true;
    }

    public boolean isBipartite_DFS(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] colors = new int[graph.length];
        for(int i = 0 ; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        int i = 0;
        for(int[] edge : graph) {
            for(int node : edge) {
                adjList.get(i).add(node);
            }
            i++;
        }
        Arrays.fill(colors, -1);

        for(int j = 0 ; j< colors.length ; j++) {
            if(colors[j] == -1) {
                if(!dfs(j, colors, adjList,0)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int j, int[] colors, List<List<Integer>> adjList,int color) {

        colors[j] = color;
        for(int node : adjList.get(j)) {
            if(colors[node] == -1) {
                int nodeClr= color == 1?0: 1;
                if(!dfs(node,colors,adjList,nodeClr)) return  false;
            } else if(colors[node] ==  color) return false;
        }
        return true;
    }

    boolean isCheckBFSForBipartite(int start, int[] color, List<List<Integer>> adjList) {

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        color[start] = 0;

        while(!q.isEmpty()) {
            int cnode = q.peek();
            q.poll();

            for(int node : adjList.get(cnode)) {
                //Mark the  node with color opposite to adj node
                if(color[node] == -1) {
                    int oppositeClr = color[cnode] == 1?0:1;
                    color[node] = oppositeClr;
                    q.offer(node);
                } else if(color[node] == color[cnode]) return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
      //  int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
       // int[][] graph = {{4,1},{0,2},{1,3},{2,4},{3,0}};
       // int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        int[][] graph = {{2,3,5,6,7,8,9},{2,3,4,5,6,7,8,9},{0,1,3,4,5,6,7,8,9},{0,1,2,4,5,6,7,8,9},{1,2,3,6,9},{0,1,2,3,7,8,9},{0,1,2,3,4,7,8,9},{0,1,2,3,5,6,8,9},{0,1,2,3,5,6,7},{0,1,2,3,4,5,6,7}};
        var lt = new LT785IsGraphBipartite();
        System.out.println(lt.isBipartite(graph));
        System.out.println(lt.isBipartite_DFS(graph));

    }
}
