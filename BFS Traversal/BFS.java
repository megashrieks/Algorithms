import java.util.Scanner;
class BFS{
    int adj[][];
    int verts;
    boolean visited[];
    int order[];
    int queue[];
    int rear,front;
    int count;
    BFS(int a[][],int n){
        verts = n;
        count = 0;
        rear = 0;
        front = -1;
        adj = new int[n][n];
        visited = new boolean[n];
        order = new int[n];
        queue = new int[n];
        for(int i = 0;i < n;++i){
            visited[i] = false;
            order[i] = 0;
            for(int j = 0;j < n;++j)
                adj[i][j] = a[i][j];
        }
    }
    void bfs(){
        int vertex;
        while(rear <= front){
            vertex = queue[rear++];
            visited[vertex] = true;
            order[count++] = vertex;
            for(int i = 0;i < verts;++i){
                if(visited[i] == false && adj[vertex][i] != 0)
                    queue[++front] = i;
            }
        }
    }
    void traverse(){
        for(int i = 0;i < verts;++i)
            if(visited[i] == false){
                queue[++front] = i;
                bfs();
            }
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
        BFS b = new BFS(a,n);
        b.traverse();
        System.out.print("The BFS traversal is : ");
        b.print();
    }
}