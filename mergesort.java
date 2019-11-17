import java.io.*;
class Merge{
    int a[];
    int h[];
    Merge(int n[]){
        a=new int[n.length];
        h=new int[n.length];
        for(int i=0;i<n.length;i++)
        a[i]=n[i];
    }
    void sort(int lo,int hi){
        if(lo<hi){
        int mid=(lo+hi)/2;
        sort(lo,mid);
        sort(mid+1,hi);
        merge(lo,mid,hi);
    }
    }
    void merge(int lo,int mid,int hi){
        for(int i=lo;i<=hi;i++)
            h[i]=a[i];
        int i=lo;
        int j=mid+1;
        int k=lo;
        while(i<=mid&&j<=hi){
            if(h[i]<=h[j]) {a[k]=h[i];i++;}
            else {a[k]=h[j];j++;}
            k++;
        }
        while(i<=mid){
            a[k]=h[i];
            k++;
            i++;
        }
    }
    void show(){
        System.out.println("After Sorting");
        for(int i=0;i<a.length;i++) 
        System.out.println(a[i]);
    }
}
class UseMerge{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Length of array");
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        for(int i=0;i<n;i++) 
        arr[i]=Integer.parseInt(br.readLine());
        Merge m=new Merge(arr);
        m.sort(0, n-1);
        m.show();
    }
}