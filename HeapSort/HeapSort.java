import java.util.Scanner;

class HeapSort{
    int a[];
    HeapSort(int A[]){
        a = new int[A.length];
        for(int i = 0;i < A.length;++i)
            a[i] = A[i];
    }
    void heapify(int n){
        for(int i = n/2-1;i >= 0;--i){
            boolean heap = false;
            int k = i;
            while(!heap && k < n/2){
                int l = 2 * k + 1;
                int r = 2 * k + 2;
                int largest = k;
                if(l < n && a[l] > a[largest]) largest = l;
                if(r < n && a[r] > a[largest]) largest = r;
                if(largest == k) heap = true;
                else {
                    int temp = a[largest];
                    a[largest] = a[k];
                    a[k] = temp;
                    k = largest;
                }
            }
        }
    }
    void sort(){
        int n = a.length;
        heapify(n);
        for(int i=n-1;i >= 0;--i){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapify(i);
        }
    }
    void print(){
        for(int i = 0;i < a.length;++i){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = s.nextInt();
        int a[] = new int[n];
        System.out.print("Enter the elements : ");
        for(int i = 0;i < n;++i)
            a[i] = s.nextInt();
        HeapSort h = new HeapSort(a);
        h.sort();
        System.out.print("The sorted elements are : ");
        h.print();
    }
}