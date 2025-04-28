import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {

    public static Graph parseFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int n = Integer.parseInt(br.readLine());
        Graph graph = new Graph(n);

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.trim().split("\\s+");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);
            graph.addEdge(from, to, capacity);
        }

        br.close();
        return graph;
    }

}
