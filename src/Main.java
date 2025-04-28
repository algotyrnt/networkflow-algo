import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Graph graph = FileParser.parseFile("benchmark/bridge_1.txt");
        int source = 0;
        int sink = graph.size() - 1;
        int maxFlow = MaxFlowSolver.edmondsKarp(graph, source, sink);

        System.out.println("\n------ Final Results ------");
        System.out.println("Maximum Flow: " + maxFlow);

        System.out.println("\n---- Flow Distribution ----");
        for (int u = 0; u < graph.size(); u++) {
            for (Edge e : graph.getAdj(u)) {
                if (!e.isResidual() && e.flow > 0) {
                    System.out.println("Edge " + e.from + " -> " + e.to + " | flow = " + e.flow + " / " + e.capacity);
                }
            }
        }

    }
}
