import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxFlowSolver {

    public static int edmondsKarp(Graph graph, int s, int t) {
        int maxFlow = 0;
        int[] parent = new int[graph.size()];
        Edge[] path = new Edge[graph.size()];

        while (true) {
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);

            while (!queue.isEmpty() && parent[t] == -1) {
                int curr = queue.poll();
                for (Edge e : graph.getAdj(curr)) {
                    if (parent[e.to] == -1 && e.remainingCapacity() > 0) {
                        parent[e.to] = curr;
                        path[e.to] = e;
                        queue.add(e.to);
                        if (e.to == t) break;
                    }
                }
            }

            if (parent[t] == -1) break; // No more augmenting path

            int bottleneck = Integer.MAX_VALUE;
            for (int i = t; i != s; i = parent[i]) {
                bottleneck = Math.min(bottleneck, path[i].remainingCapacity());
            }

            for (int i = t; i != s; i = parent[i]) {
                path[i].augment(bottleneck);
            }

            maxFlow += bottleneck;
            System.out.println("Augmented by " + bottleneck + ", current max flow: " + maxFlow);
        }

        return maxFlow;
    }
}
