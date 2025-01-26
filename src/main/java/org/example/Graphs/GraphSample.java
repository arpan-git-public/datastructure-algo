package org.example.Graphs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GraphSample {
    private Map<VertexSample, List<VertexSample>> adjVertices;

    GraphSample() {
        this.adjVertices = new HashMap<>();
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new VertexSample(label),new ArrayList<>());
    }

    void removeVertex(String label) {
        VertexSample v = new VertexSample(label);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }

    void addEdge(String label1, String label2){
        VertexSample v1 = new VertexSample(label1);
        VertexSample v2 = new VertexSample(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        VertexSample v1 = new VertexSample(label1);
        VertexSample v2 = new VertexSample(label2);
        adjVertices.get(v1).removeIf(x->x.equals(v2));
        adjVertices.get(v2).removeIf(x->x.equals(v1));
    }


    List<VertexSample> getAdjVertices(String label){
        return adjVertices.get(new VertexSample(label));
    }

    public static void main(String[] args) {
        GraphSample graph = new GraphSample();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob","Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        List<VertexSample> adjVertices = graph.getAdjVertices("Bob");
        adjVertices.forEach(System.out::println);
    }

}
class VertexSample {
    private String label;
    public VertexSample(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object label) {
        return this.label.equals(label);
    }
}
