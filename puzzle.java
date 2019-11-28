import java.io.*;
import java.util.Random;
class Puzz{
    int arr[][];
    int a[][];
    int size;
    int pos;
    Puzz(int n){
        arr=new int[n][n];
        a=new int[n][n];
        size=n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==n-1 && j==n-1)
                    a[i][j]=arr[i][j]=0;
                else
                    a[i][j]=arr[i][j]=(n*i)+j+1;
            }
        }
        shuffle();
    }
    void shuffle(){
        Random r=new Random();
        int i=0;
        while(i<arr.length){
            int p=r.nextInt(size);
            int q=r.nextInt(size);
            int t=r.nextInt(size);
            int s=r.nextInt(size);
            int temp=arr[p][q];
            arr[p][q]=arr[t][s];
            arr[t][s]=temp;
            i++;
        }
    }
    void play(int x){
        if(check(x)){
            int a=0;int b=0;int c=0;int d=0;
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(arr[i][j]==0){a=i;b=j;}
                }
            }
            for(int k=0;k<size;k++){
                for(int l=0;l<size;l++){
                    if(arr[k][l]==x){c=k;d=l;}
                }
            }
            int temp=arr[a][b];
            arr[a][b]=arr[c][d];
            arr[c][d]=temp;
        }
        else{
            System.out.println("Enter a valid Input");
        }
    }
    void show(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    boolean check(int x){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(arr[i][j]==0){
                    System.out.println(i+" "+j);
                    return option(i,j,x);}
            }
        }
        return false;
    }
    boolean option(int i,int j,int x){
        if(i>0 && arr[i-1][j]==x){
                return true;
        }
        if(i<size-1 && arr[i+1][j]==x){
                return true;
        }
        if(j>0 && arr[i][j-1]==x){
                return true;
        }
        if(j<size-1 && arr[i][j+1]==x){
                return true;
        }
        else
        return false;
    }
    boolean iseq(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(arr[i][j]!=a[i][j])
                    return false;
            }
        }
        return true;
    }
    void reveal(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
class UsePuzz{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the grid size");
        int n=Integer.parseInt(br.readLine());
        Puzz p=new Puzz(n);
        System.out.println("Enter number to be replaced with blank & Nothing to exit");
        while(true){
            p.show();
            String s=br.readLine();
            if(s.isEmpty()) break;
            if(!p.iseq()){
                p.play(Integer.parseInt(s));
            }
            else break;
        }
        System.out.println("Your Cube");
        p.show();
        System.out.println("Expected Cube");
        p.reveal();
    }
}