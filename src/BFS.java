import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> BFS(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                bfs(i,visited,adj,ans);
            }
        }
        return ans;
    }

    public void bfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int u =  q.poll();
            ans.add(u);
            for(int v : adj.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }

    }

    public static void main(String[] args) {
        // Sample test case
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        BFS bfs = new BFS();
       ArrayList<Integer> sol=  bfs.BFS(g.getVertices(),g.getAdj());
       System.out.println(sol);

    }
}