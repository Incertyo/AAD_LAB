import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> adj;
    int vertices;
    public Graph(int vertices){
        this.vertices = vertices;
        adj = new ArrayList<>() ;
        for(int i = 0; i < vertices; i++){
            adj.add(new ArrayList<>());
        }
    }
    public int getVertices(){
        return vertices;
    }
    public void addEdge(int v1, int v2,boolean isDirected){
        adj.get(v1).add(v2);
        if(!isDirected){
            adj.get(v2).add(v1);
        }
    }
    public void addEdge(int v1, int v2){
        addEdge(v1,v2,false);
    }
    public ArrayList<Integer> getAdj(int v){
        return adj.get(v);
    }
    public ArrayList<ArrayList<Integer>> getAdj(){
        return adj;
    }
}
