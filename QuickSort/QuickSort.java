import java.util.Scanner;

class QuickSort{
    int A[];
    QuickSort(int a[]){
        A = new int[a.length];
        for(int i = 0;i < a.length;++i) A[i] = a[i];
    }
    private void swap(int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private int partition(int l,int h){
        int pivot = A[h];
        int i = l-1;
        for(int j = l;j < h;++j){
            if(A[j] < pivot)
                swap(++i,j);
        }
        swap(++i,h);
        return i;
    }
    public void sort(int l,int h){
        if(l < h){
            int p = partition(l,h);
            sort(l,p-1);
            sort(p+1,h);
        }
    }
    public void print(){
        for(int i = 0;i < A.length;++i){
            System.out.print(A[i]+" ");
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int a[] = new int[s.nextInt()];
        System.out.print("Enter the elements : ");
        for (int i = 0;i < a.length;++i)
            a[i] = s.nextInt();
        QuickSort m = new QuickSort(a);
        m.sort(0,a.length-1);
        m.print();
    }
}