import java.util.Scanner;

class SelectionSort{
    int a[];
    SelectionSort(int A[]){
        a = new int[A.length];
        for(int i = 0;i < A.length;++i)
            a[i] = A[i];
    }
    void sort(){
        for(int i = 0;i < a.length;++i){
            int largest = i;
            for(int j = i+1;j < a.length;++j)
                if(a[j] < a[largest]) largest = j;
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;
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
        System.out.print("The sorted elements are : ");
        SelectionSort ss = new SelectionSort(a);
        ss.sort();
        ss.print();
    }
}