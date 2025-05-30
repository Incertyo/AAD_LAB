import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static int MST(Graph g, int[][] weights) {
        int V = g.getVertices();
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int sum = 0;

        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0], weight = edge[1];

            if (visited[u]) continue;
            visited[u] = true;
            sum += weight;

            for (int v : g.getAdj(u)) {
                if (!visited[v]) {
                    pq.offer(new int[]{v, weights[u][v]});
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        int[][] weights = {
                {0, 2, 3, 0, 0},
                {2, 0, 0, 4, 0},
                {3, 0, 0, 0, 6},
                {0, 4, 0, 0, 5},
                {0, 0, 6, 5, 0}
        };

        System.out.println("Minimum Spanning Tree Weight: " + MST(g, weights));
    }
}