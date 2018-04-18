import java.util.Scanner;

class Edge{
    public int u,v,cost;
    Edge(int m,int n,int c){
        u = m;
        v = n;
        cost = c;
    }
}

class Kruskal{
    int verts;
    int edges;
    Edge e[];
    Edge mstc[];
    int roots[];
    int count;
    Kruskal(Edge ed[],int m,int n){
        verts = n;
        edges = m;
        mstc = new Edge[n];
        roots = new int[n];
        e = new Edge[m];
        for(int i = 0;i < n;++i)
            roots[i] = i;
        for(int i = 0;i < m;++i)
            e[i] = ed[i];
    }
    void sort(Edge e[]){
        for(int i = 0;i < edges;++i){
            int min = i;
            for(int j = i+1;j < edges;++j){
                if(e[j].cost < e[min].cost) min = j;
            }
            Edge t = e[i];
            e[i] = e[min];
            e[min] = t;
        }
    }
    void mst(int vertex){
        sort(e);
        int i = 0;
        count = 0;
        while(count < verts-1){
            int x = find(e[i].u);
            int y = find(e[i].v);
            if(x != y){
                roots[x] = y;
                mstc[count++] = e[i];
            }
            i++;
        }
    }
    int find(int i){
        if(roots[i] == i) return i;
        return find(roots[i]);
    }
    void print(){
        int cost = 0;
        for(int i = 0;i < count;++i){
            System.out.println(mstc[i].u+" - "+mstc[i].v);
            cost += mstc[i].cost;
        }
        System.out.println("Total cost is : "+cost);
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of edges and vertices: ");
        int m = s.nextInt();
        int n = s.nextInt();
        Edge e[] = new Edge[m];
        System.out.println("Enter the edges and cost");
        for(int i = 0;i < n;++i)
            e[i] = new Edge(s.nextInt(),s.nextInt(),s.nextInt());
        Kruskal k = new Kruskal(e,m,n);
        k.mst();
        System.out.println("The edges of the MST are ");
        k.print();
    }
}