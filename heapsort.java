import java.io.*;
class HS{
    int arr[];
    int n;
    HS(int a[]){
        n=a.length-1;
        arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=a[i];
        }
    }
    void sort(){
        for(int i=n/2;i>0;i--){
            sink(i);
        }
        while(n>1){
            int temp=arr[n];
            arr[n]=arr[1];
            arr[1]=temp;
            n--;
            sink(1);
        }
    }
    void sink(int k){
        while(2*k<=n){
            int j=2*k;
            if(j<n && arr[j]<arr[j+1]) j++;
            if(arr[j]<arr[k]) break;
            int temp=arr[j];
            arr[j]=arr[k];
            arr[k]=temp;
            k=j;
        }
    }
    void show(){
        System.out.println("Sorted Array");
        for(int i=1;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
class UseHS{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter length of the array");
        int n=Integer.parseInt(br.readLine());
        n++;
        int arr[]=new int[n];
        System.out.println("Enter Elements");
        for(int i=1;i<arr.length;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        HS h=new HS(arr);
        h.sort();
        h.show();
    }
}