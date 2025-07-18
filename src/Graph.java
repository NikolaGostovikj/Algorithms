import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public Map<Vertex, List<Vertex>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }


    void addVertex(Vertex vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    void removeVertex(Vertex vertex) {
        adjacencyList.remove(vertex);
        for (List<Vertex> list : adjacencyList.values()) {
            list.remove(vertex); //remove edges also
        }

    }

    void addEdge(Vertex v1, Vertex v2) {
        adjacencyList.get(v1).add(v2); //undirected graph
        adjacencyList.get(v2).add(v1);
    }

    void removeEdge(Vertex v1, Vertex v2) {
        List<Vertex> edgesV1 = adjacencyList.get(v1);
        List<Vertex> edgesV2 = adjacencyList.get(v2);
        if(edgesV1!=null){ //check if vertex has edges
            edgesV1.remove(v2);
        }
        if(edgesV2!=null){
            edgesV2.remove(v1);
        }
    }

    Graph createGraph() {
        Graph graph = new Graph();
        Map<Integer, Vertex> vertices = new HashMap<>();

        for (int i = 1; i <= 8; i++) {
            Vertex vertex = new Vertex(i);
            graph.addVertex(vertex);
            vertices.put(i, vertex);
        }

        graph.addEdge(vertices.get(1), vertices.get(2));
        graph.addEdge(vertices.get(1), vertices.get(3));
        graph.addEdge(vertices.get(2), vertices.get(4));
        graph.addEdge(vertices.get(3), vertices.get(5));
        graph.addEdge(vertices.get(4), vertices.get(6));
        graph.addEdge(vertices.get(5), vertices.get(6));
        graph.addEdge(vertices.get(6), vertices.get(7));
        graph.addEdge(vertices.get(7), vertices.get(8));

        return graph;
    }


    void printGraph() {
        System.out.println("---Unidirected Graph---");
        for (Vertex vertex : adjacencyList.keySet()) {
            System.out.println("Vertex " + String.valueOf(vertex.id) + " has " + adjacencyList.get(vertex).toString());
        }
    }

    void depthFirstSearch(Graph graph, Vertex root) {
                       
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph = graph.createGraph();
        graph.printGraph();
    }
}
