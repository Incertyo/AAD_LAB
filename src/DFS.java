import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    public ArrayList<Integer> DFS(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[v];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, res);
            }
        }
        return res;
    }

    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        visited[node] = true;
        res.add(node);
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfs(i, visited, adj, res);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int e = scanner.nextInt();

        System.out.println("Enter edges (start end): ");
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v1 = scanner.nextInt();
            adj.get(u).add(v1);
            adj.get(v1).add(u); // If the graph is undirected
        }

        DFS dfsTraversal = new DFS();
        ArrayList<Integer> result = dfsTraversal.DFS(v, adj);

        System.out.println("DFS Traversal: " + result);

        scanner.close();
    }
}