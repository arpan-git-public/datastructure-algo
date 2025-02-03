package com.datastructure.problems.Graphs;

public class GraphMatrix {
    private int[][] adjMatrix;
    private int numVertices;

    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int from, int to) {
        this.adjMatrix[from][to] = 1; //for unweighted graph
        //for weighted graph use weight instead of 1
    }

    public void printGraph() {
        for(int i = 0 ; i < numVertices ; i++) {
            System.out.print( i + " : ");
            for(int j = 0 ; j < numVertices; j++) {
                System.out.print( adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        var lt = new GraphMatrix(5);
        lt.addEdge(0,1);
        lt.addEdge(0,2);
        lt.addEdge(1,2);
        lt.addEdge(2,3);
        lt.addEdge(3,4);

        lt.printGraph();
    }

}
