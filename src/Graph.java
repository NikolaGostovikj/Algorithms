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
        Graph graph = new Graph(); //add nodes from 1 to 8
        for (int i = 1; i <= 8 ; i++) {
            Vertex vertex = new Vertex(i);
            graph.addVertex(vertex);
        }
        return graph;
    }
    void addEdges(Graph graph) {

        


    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.createGraph();

    }
}
