import java.io.*;
class Str{
    String arr[];
    String h[];
    Str(String a[]){
        arr=new String[a.length];
        h=new String[a.length];
        for(int i=0;i<a.length;i++){
            arr[i]=a[i].toLowerCase();
        }
    }
    void sort(int lo,int hi){
        if(lo==hi) return;
        int mid=(lo+hi)/2;
        sort(lo,mid);
        sort(mid+1,hi);
        merge(lo,mid,hi);
    }
    void merge(int lo,int mid,int hi){
        for(int i=lo;i<=hi;i++)
            h[i]=arr[i];
        int i=lo;
        int k=lo;
        int j=mid+1;
        while(i<=mid && j<=hi){
            int min=h[i].length();
            if(min>h[j].length()) min=h[j].length();
            int f=0;
            for(int x=0;x<min;x++){
                if(f==0){
                    if(h[i].charAt(x)>h[j].charAt(x)) f=1;
                    else if(h[i].charAt(x)<h[j].charAt(x)) f=2;
                }
            }
            if(f==0){
                if(h[i].length()<=h[j].length()) f=2;
                else f=1;
            }
            if(f==2){arr[k]=h[i];i++;}
            else{arr[k]=h[j];j++;}
            k++;
        }
        while(i<=mid){
            arr[k]=h[i];
            i++;
            k++;
        }
    }
    void show(){
        System.out.println("After sorting");
        for(int i=0;i<arr.length;i++) 
            System.out.println(arr[i]);
    }
}
class UseMerge{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter length of array");
        int n=Integer.parseInt(br.readLine());
        String arr[]=new String[n];
        for(int i=0;i<n;i++) arr[i]=br.readLine();
        Str so=new Str(arr);
        so.sort(0, n-1);
        so.show();
    }
}