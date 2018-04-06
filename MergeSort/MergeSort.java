import java.util.Scanner;

class MergeSort{
    int A[];
    MergeSort(int a[]){
        A = new int[a.length];
        for(int i = 0;i < a.length;++i) A[i] = a[i];
    }
    public void partition(int l,int h){
        int mid = ( l + h ) / 2;
        if(l < h){
            partition(l,mid);
            partition(mid+1,h);
        }
        merge(l,h);
    }
    private void merge(int l,int h){
        int mid = ( l + h ) / 2;
        int temp[] = new int[h - l + 1];
        int tIndex = 0;
        int i = l;
        int j = mid + 1;
        while(i <= mid && j <= h){
            if(A[i] < A[j])
                temp[tIndex++] = A[i++];
            else
                temp[tIndex++] = A[j++];
        }
        while(i <= mid) temp[tIndex++] = A[i++];
        while(j <= h) temp[tIndex++] = A[j++];
        for(int k = l;k <= h;++k) A[k] = temp[k-l];
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
        MergeSort m = new MergeSort(a);
        m.partition(0,a.length-1);
        m.print();
    }
}