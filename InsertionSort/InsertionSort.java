import java.util.Scanner;

class InsertionSort{
    int a[];
    InsertionSort(int A[]){
        a = new int[A.length];
        for(int i = 0;i < A.length;++i)
            a[i] = A[i];
    }
    void sort(){
        for(int i = 1;i < a.length;++i){
            int key = a[i];
            int j;
            for(j = i-1;(j >= 0 && key < a[j]);--j)
                a[j+1] = a[j];
            a[j+1] = key;
        }
    }
    void print(){
        for(int i = 0;i < a.length;++i)
            System.out.print(a[i]+" ");
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of elements : ");
        int n = s.nextInt();
        int a[] = new int[n];
        System.out.print("Enter the elements : ");
        for(int i = 0;i < n;++i)
            a[i] = s.nextInt();
        InsertionSort i = new InsertionSort(a);
        i.sort();
        System.out.print("The sorted elements are : ");
        i.print();
    }
}