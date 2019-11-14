import java.io.*;
class QuickFind{
    private int[] id;
    QuickFind(int N){
        id=new int[N];
        for(int i=0;i<id.length;i++){
            id[i]=i;
        }
    }
    void union(int a,int b){
        int p=id[a];
        int q=id[b];
        for(int i=0;i<id.length;i++){
            if(id[i]==p){
                id[i]=q;
            }
        }
    }
    boolean isConnected(int a,int b){
        return id[a]==id[b];
    }
}
class TQ{
    public static void main(String[] args) throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int N=Integer.parseInt(br.readLine());
       QuickFind q=new QuickFind(N);
       while(true){
           String s=br.readLine();
           if(s.isEmpty()){break;}
           String str[]=s.split(" ");
           int p=Integer.parseInt(str[0]);
           int w=Integer.parseInt(str[1]);
           if(!q.isConnected(p,w)){
               q.union(p,w);
               System.out.println(p+" "+w);
           }
       }     
    }
}