import java.util.Scanner;

class BubbleSort{
    int a[];
    BubbleSort(int A[]){
        a = new int[A.length];
        for(int i = 0;i < A.length;++i)
            a[i] = A[i];
    }
    void sort(){
        for(int i = 0;i < a.length-1;++i){
            for(int j = 0;j < a.length-i-1;++j){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
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
        BubbleSort b = new BubbleSort(a);
        b.sort();
        b.print();
    }
}