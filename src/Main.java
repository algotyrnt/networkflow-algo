import java.io.IOException;

/**
 *  Name - L. W. P. D. T. Bandara
 *  Student Id - w2083155
 *  entry point for the program
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // Parse the graph from a file
        Graph graph = FileParser.parseFile("benchmark/ladder_2.txt");

        // Define the source and sink
        int source = 0;
        int sink = graph.size() - 1;

        long startTime = System.nanoTime();
        int maxFlow = MaxFlowSolver.edmondsKarp(graph, source, sink); // Calculate the maximum flow
        long endTime = System.nanoTime();

        // Display the final results
        System.out.println("\n------ Final Results ------");

        System.out.println("\nFlow Distribution: ");
        for (int u = 0; u < graph.size(); u++) {
            for (Edge e : graph.getAdj(u)) {
                // display non-residual edges with positive flow
                if (!e.isResidual() && e.flow > 0) {
                    System.out.println(" Edge " + e.from + " -> " + e.to + " | flow = " + e.flow + " / " + e.capacity);
                }
            }
        }

        System.out.println("\nMaximum Flow: " + maxFlow);

        System.out.println("\nExecution Time: " +(endTime-startTime)/1000000 +" milliseconds");

    }
}
