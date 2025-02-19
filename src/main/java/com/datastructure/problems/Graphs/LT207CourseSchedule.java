package com.datastructure.problems.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LT207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0 ; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] edge: prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
        }

        for(List<Integer> ls : adjList) {
            for(int node : ls) {
                indegree[node]++;
            }
        }

        // indegree[node]++;

        // topological sort (make linear ordering)
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> topo = new ArrayList<>();
        for(int i = 0; i< numCourses; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            topo.add(node);
            for(int nnode : adjList.get(node)) {
                indegree[nnode]--;
                if(indegree[nnode] == 0) q.offer(nnode);
            }
        }

        return topo.size() == numCourses;
    }

    public static void main(String[] args) {
        int[][] course = {{1,0}};
        int numCourse = 2;
        var lt = new LT207CourseSchedule();
        System.out.println(lt.canFinish(numCourse,course));
    }
}
