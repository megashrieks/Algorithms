import java.util.Scanner;
class DFS{
    int adj[][];
    int verts;
    boolean visited[];
    int order[];
    int count;
    DFS(int a[][],int n){
        verts = n;
        count = 0;
        adj = new int[n][n];
        visited = new boolean[n];
        order = new int[n];
        for(int i = 0;i < n;++i){
            visited[i] = false;
            order[i] = 0;
            for(int j = 0;j < n;++j)
                adj[i][j] = a[i][j];
        }
    }
    void dfs(int vertex){
        order[count++] = vertex;
        visited[vertex] = true;
        for(int i = 0;i < verts;++i){
            if(visited[i] == false && adj[vertex][i] != 0)
                dfs(i);
        }
    }
    void traverse(){
        for(int i = 0;i < verts;++i)
            if(visited[i] == false)
                dfs(i);
    }
    void print(){
        for(int i = 0;i < verts;++i)
            System.out.print(order[i]+" ");
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of vertices : ");
        int n = s.nextInt();
        int a[][] = new int[n][n];
        System.out.println("Enter the adjacency matrix");
        for(int i = 0;i < n;++i)
            for(int j = 0;j < n;++j)
                a[i][j] = s.nextInt();
        DFS d = new DFS(a,n);
        d.traverse();
        System.out.print("The DFS traversal is : ");
        d.print();
    }
}