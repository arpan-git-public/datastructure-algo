package com.datastructure.problems.Graphs;

import java.util.*;

public class LT787CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<Edge>> map = new HashMap<>();
        for(int[] flight: flights) {
            map.computeIfAbsent(flight[0],x-> new ArrayList<>()).add(new Edge(flight[1],flight[2]));
        }

        Queue<Route> q = new ArrayDeque<>();
        q.offer(new Route(0,src,0));
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);

        while(!q.isEmpty()) {
            Route cRoute = q.poll();
            // if(cRoute.stop > k + 1) return -1;
            List<Edge> edges = map.get(cRoute.node);
            if(edges != null && !edges.isEmpty()) {
                for(Edge edge : edges) {
                    int routePrice = cRoute.price + edge.price;
                    if(routePrice < cost[edge.node] && cRoute.stop < k + 1) {
                        cost[edge.node] = routePrice;
                        q.offer(new Route(cRoute.stop + 1, edge.node, routePrice));
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    private record Edge(int node, int price) {}

    private record Route(int stop, int node, int price) {}

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n = 4, k =1;
        int src = 0 , dst = 3;
        var lt = new LT787CheapestFlightsWithinKStops();
        System.out.println(lt.findCheapestPrice(n,flights,src,dst,k));


    }
}
