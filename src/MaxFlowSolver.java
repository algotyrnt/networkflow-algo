import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Name - L. W. P. D. T. Bandara
 *  Student Id - w2083155
 *  Implements the Edmonds-Karp algorithm to solve the maximum flow problem
 */
public class MaxFlowSolver {

    public static int edmondsKarp(Graph graph, int s, int t) {
        int maxFlow = 0;
        int[] parent = new int[graph.size()];
        Edge[] path = new Edge[graph.size()];

        while (true) {
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s); // Start BFS from the source

            // BFS
            while (!queue.isEmpty() && parent[t] == -1) {
                int curr = queue.poll();
                for (Edge e : graph.getAdj(curr)) {
                    // Check if the edge can be part of the augmenting path
                    if (parent[e.to] == -1 && e.remainingCapacity() > 0) {
                        parent[e.to] = curr;
                        path[e.to] = e;
                        queue.add(e.to);
                        if (e.to == t) break; // Stop BFS if the sink is reached
                    }
                }
            }

            if (parent[t] == -1) break; // If no augmenting path is found, break the loop

            // Find the bottleneck capacity in the augmenting path
            int bottleneck = Integer.MAX_VALUE;
            for (int i = t; i != s; i = parent[i]) {
                bottleneck = Math.min(bottleneck, path[i].remainingCapacity());
            }

            // Augment the flow along the path
            for (int i = t; i != s; i = parent[i]) {
                path[i].augment(bottleneck);
            }

            maxFlow += bottleneck;
            System.out.println("Augmented by " + bottleneck + ", current max flow: " + maxFlow);
        }

        return maxFlow;
    }
}
