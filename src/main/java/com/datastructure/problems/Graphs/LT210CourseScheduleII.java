package com.datastructure.problems.Graphs;

import java.util.*;

public class LT210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] req : prerequisites) {
            adjList.get(req[0]).add(req[1]);
        }
        //calculate indegree of node
        int[] indegree = new int[numCourses];
        for(List<Integer> list : adjList) {
            for(int node : list) {
                indegree[node]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> topo = new ArrayList<>();
        for(int i = 0; i < numCourses;i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            topo.add(node);

            for(int nnode: adjList.get(node)) {
                indegree[nnode]--;
                if(indegree[nnode] == 0) q.offer(nnode);
            }
        }
        Collections.reverse(topo);
        int[] order = topo.stream().mapToInt(i->i).toArray();

        return order.length == numCourses? order : new int[0];
    }

    public static void main(String[] args) {
        int[][] course = {{1,0},{2,0},{3,1},{3,2}};
        int numCourse = 4;
        var lt = new LT207CourseSchedule();
        System.out.println(lt.canFinish(numCourse,course));
    }
}
