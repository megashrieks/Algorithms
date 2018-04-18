import java.util.Scanner;

class Dijkstra{
    int dist[];
    int adj[][];
    int verts;
    int INF = 9999;
    boolean selected[];
    Dijkstra(int a[][],int n){
        dist = new int[n];
        adj = new int[n][n];
        selected = new boolean[n];
        verts = n;
        for(int i = 0;i < n;++i){
            dist[i] = INF;
            selected[i] = false;
            for(int j = 0;j < n;++j)
                adj[i][j] = a[i][j];
        }
    }
    int min_vertex(){
        int minimum = INF,min_index = -1;
        for(int i = 0;i < verts;++i){
            if(selected[i] == false && dist[i] <= minimum)
                {minimum = dist[i];min_index = i;}
        }
        return min_index;
    }
    void shortest(int vertex){
        dist[vertex] = 0;
        for(int i = 0;i < verts-1;++i){
            int u = min_vertex();
            selected[u] = true;
            for(int j = 0;j < verts;++j){
                if(selected[j] == false && adj[u][j] != 0 && dist[u]+adj[u][j] < dist[j])
                    dist[j] = dist[u]+adj[u][j];
            }
        }
    }
    void print(){
        for(int i = 0;i < verts;++i)
            System.out.print(dist[i]+" ");
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int n = s.nextInt();
        int a[][] = new int[n][n];
        System.out.println("Enter the adjacency matrix");
        for(int i = 0;i < n;++i)
            for(int j = 0;j < n;++j)
                a[i][j] = s.nextInt();
        System.out.print("Enter the root vertex : ");
        int vertex = s.nextInt();
        Dijkstra d = new Dijkstra(a,n);
        d.shortest(vertex);
        System.out.print("The shortest distance from vertex "+vertex+" to other vertices are : ");
        d.print();
    }
}