/**
 *  Name - L. W. P. D. T. Bandara
 *  Student Id - w2083155
 *  Represents an edge in a flow network.
 */
public class Edge {

    public final int from, to;
    public final int capacity;
    public int flow;
    public Edge residual;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int remainingCapacity() {
        return capacity - flow;
    }

    public void augment(int bottleNeck) {
        flow += bottleNeck;
        residual.flow -= bottleNeck;
    }

    public boolean isResidual() {
        return capacity == 0;
    }

    @Override
    public String toString() {
        return String.format("Edge %d -> %d | flow = %d / %d", from, to, flow, capacity);
    }

}
