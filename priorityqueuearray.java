import java.io.*;
class PriorityQueue{
    int arr[];
    int n;
    PriorityQueue(){
        arr=new int[1];
        n=-1;
    }
    void insert(int N){
        if(n==arr.length-1) resize(2*arr.length);
            arr[++n]=N;
    }
    void delMax(){
        int max=0;
        int x=0;
        for(int i=0;i<=n;i++){ 
            if(arr[i]>max) {
                max=arr[i];
                x=i;
            }
        }
        int temp=arr[x];
        arr[x]=arr[n];
        arr[n]=temp;
        System.out.println("removed "+arr[n]);
        n--;
        if(n<=arr.length/4) resize(arr.length/2);
    }
    void show(){
        for(int i=0;i<=n;i++)
            System.out.println(arr[i]);
    }
    void resize(int o){
        int a[]=new int[o];
        for(int i=0;i<=n;i++){
            a[i]=arr[i];
        }
        arr=a;
        System.out.println("Array resized");
    }
}
class UseArr{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue m=new PriorityQueue();
        System.out.println("Enter nummber to be inserted \n Enter Space bar to delete and \nNothing to exit");
    while(true){
        String s=br.readLine();
        if(s.isEmpty()) break;
        else if(s.isBlank()){m.delMax();}
        else{
            m.insert(Integer.parseInt(s));
        }
    }
    m.show();
    }
}