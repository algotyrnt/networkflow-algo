import java.util.ArrayList;
import java.util.List;

/**
 *  Name - L. W. P. D. T. Bandara
 *  Student Id - w2083155
 *  Represents a graph for a flow network.
 */
public class Graph {

    private final int n;
    private final List<List<Edge>> adjList;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
    }

    public void addEdge(int from, int to, int capacity) {
        Edge e1 = new Edge(from, to, capacity); // Forward edge
        Edge e2 = new Edge(to, from, 0); // Residual edge
        e1.residual = e2;
        e2.residual = e1;
        adjList.get(from).add(e1);
        adjList.get(to).add(e2);
    }

    public List<Edge> getAdj(int node) {
        return adjList.get(node);
    }

    public int size() {
        return n;
    }

}
