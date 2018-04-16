import java.util.Scanner;

class Floyd{
    int A[][];
    int vertices;
    int INF = 9999;
    Floyd(int a[][],int n){
        A = new int[n][n];
        vertices = n;
        for(int i = 0;i < n;++i)
            for(int j = 0;j < n;++j)
                if(a[i][j] == 0) A[i][j] = INF;
                else A[i][j]=a[i][j];
    }
    void minDistance(){
        for(int k = 0;k < vertices;++k)
            for(int j = 0;j < vertices;++j)
                for(int i = 0;i < vertices;++i)
                    if(A[i][j] > A[i][k]+A[k][j])
                        A[i][j] = A[i][k]+A[k][j];
    }
    void print(){
        for(int i = 0;i < vertices;++i){
            for(int j = 0;j < vertices;++j)
                System.out.print((A[i][j]==INF?0:A[i][j])+" ");
            System.out.println();
        }
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
        Floyd f = new Floyd(a,n);
        f.minDistance();
        System.out.println("The minimum distance adjacency matrix is");
        f.print();

    }
}