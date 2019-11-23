import java.io.*;
class PQ{
    int arr[];
    int n=0;
    PQ(){
        arr=new int[2];
    }
    void insert(int x){
        if(n==arr.length-1) resize(2*arr.length);
        arr[++n]=x;
        swim(n);
    }
    void swim(int k){
        while(k>1 && arr[k/2]<arr[k]){
                int temp=arr[k/2];
                arr[k/2]=arr[k];
                arr[k]=temp;
                k=k/2;
        }
    }
    void delMax(){
        int x=arr[1];
        int temp=arr[1];
        arr[1]=arr[n];
        arr[n]=temp;
        n--;
        sink(1);
        arr[n+1]=0;
        System.out.println("Removed "+x);
        if(n==arr.length/4) resize(arr.length/2);
    }
    void sink(int k){
        while(2*k<=n){
            int j=2*k;
            if(j<n && arr[j]<arr[j+1]) j++;
            if(arr[k]>arr[j]) break;
            int temp=arr[k];
            arr[k]=arr[j];
            arr[j]=temp;
            k=j;
        }
    }
    void resize(int k){
        int a[]=new int[k];
        for(int i=0;i<=n;i++){
            a[i]=arr[i];
        }
        arr=a;
        System.out.println("Array Resized");
    }
    void show(){
        for(int i=1;i<=n;i++) System.out.println(arr[i]);
    }
}
class UsePQ{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PQ p=new PQ();
        System.out.println("Enter number to be inserted\nSpace Key to delete\nNothing to exit");
        while(true){
            String s=br.readLine();
            if(s.isEmpty()) break;
            else if(s.isBlank()) p.delMax();
            else p.insert(Integer.parseInt(s));
        }
        p.show();
    }
}