import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testDFS() {
        Graph graph = new Graph();
        graph = graph.createGraph();

        // Get the starting vertex (e.g., Vertex with id = 1)
        Vertex start = null;
        for (Vertex v : graph.adjacencyList.keySet()) {
            if (v.id == 1) {
                start = v;
                break;
            }
        }

        assertNotNull("Start vertex should not be null", start);

        List<Vertex> result = graph.depthFirstSearch(graph,start);
        List<Integer> visitedIds = new ArrayList<>();
        for (Vertex v : result) {
            visitedIds.add(v.id);
        }


        List<Integer> expectedIds = Arrays.asList(1,2,4,6,7,8,5,3);

        assertEquals("DFS should visit all 8 nodes", 8, visitedIds.size());
        assertTrue("DFS should contain vertex 6", visitedIds.contains(6));
        assertTrue("DFS should contain vertex 8", visitedIds.contains(8));
    }
}
