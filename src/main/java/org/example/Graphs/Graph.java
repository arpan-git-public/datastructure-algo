package org.example.Graphs;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph {
    @Getter
    private List<Vertex> vertices;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph(boolean isDirected, boolean isWeighted) {
        this.vertices = new ArrayList<>();
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }
    Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if(!this.isWeighted)
            weight = null;
        vertex1.addEdge(vertex2,weight);
        if(!this.isDirected)
            vertex2.addEdge(vertex1,weight);
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if(!isDirected)
            vertex2.removeEdge(vertex1);
    }

    public void breathFirstTraversal(Vertex start) {
        Queue<Vertex> queue = new ArrayDeque<>();
        ArrayList<Vertex> visited = new ArrayList<>();
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex.getData() + ",");
            currentVertex.getEdges().forEach( edge -> {
                if(!visited.contains(edge.getEnd())){
                    queue.add(edge.getEnd());
                    visited.add(currentVertex);
                }
            });
        }
    }

    public void depthFirstTraversal(Vertex start, ArrayList<Vertex> visited) {
        System.out.print(start.getData() + ",");
        start.getEdges().forEach(edge -> {
            Vertex neighbour = edge.getEnd();
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                depthFirstTraversal(neighbour,visited);
            }
        });
    }
}
class Vertex {
    private String data;
    private List<Edge> edges;

    public Vertex(String data){
        this.data = data;
        this.edges = new ArrayList<>();
    }

    void addEdge(Vertex vertex1,Integer weight){
        this.edges.add(new Edge(this,vertex1,weight));
    }

    void removeEdge(Vertex endVertex) {
        this.edges.removeIf(v -> v.getEnd().equals(endVertex));
    }


    List<Edge> getEdges() {
        return this.edges;
    }

    public String getData() {
        return data;
    }
}

class Edge {
    private Vertex start;
    @Getter
    private Vertex end;
    private Integer weight;

    public Edge(Vertex start, Vertex end, Integer weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(true,true);
        Vertex zero = graph.addVertex("0");
        Vertex one = graph.addVertex("1");
        Vertex two = graph.addVertex("2");
        Vertex three = graph.addVertex("3");
        Vertex four = graph.addVertex("4");

        graph.addEdge(zero, one, 1);
        graph.addEdge(one,two,1);
        graph.addEdge(two,three,7);
        graph.addEdge(three,four,8);
        graph.addEdge(four,zero,5);

        System.out.print("All Vertices: ");
        graph.getVertices().forEach(v-> System.out.print(v.getData() + ", "));
        System.out.println();
        System.out.print("All Zero Edge: ");
        three.getEdges().forEach(e -> System.out.print(e.start.getData() + " -->" + e.end.getData() + " --> " + e.weight));
        System.out.println();
        System.out.print("Breadth First Traversal: ");
        graph.breathFirstTraversal(zero);

        System.out.println();
        System.out.print("Depth First Traversal:");

        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(zero);
        graph.depthFirstTraversal(zero,visitedVertices);
    }
}
