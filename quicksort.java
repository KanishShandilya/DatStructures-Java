import java.io.*;
class QuickSort{
    int arr[];
    QuickSort(int n[]){
        arr=new int[n.length];
        for(int i=0;i<n.length;i++)
            arr[i]=n[i];
        sort(0,n.length-1);
    }
    void sort(int lo,int hi){
        if(hi<=lo) return;
        int j=partition(lo,hi);
        sort(lo,j-1);
        sort(j+1,hi);
    }
    int partition(int lo,int hi){
        int i=lo;
        int j=hi;
        while(i<j){
            while(arr[i]<=arr[lo]){
                i++;
            }
            while(arr[j]>arr[lo]){
                j--;              
            }
            if(i>=j) break;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        int temp=arr[lo];
        arr[lo]=arr[j];
        arr[j]=temp;
        return j;
    }
    void show(){
        System.out.println("After Sorting");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
class UseQuick{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter length of array");
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        System.out.println("Enter Elements");
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(br.readLine());
        QuickSort q=new QuickSort(arr);
        q.show();
    }
}