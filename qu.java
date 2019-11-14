import java.io.*;
class QuickUnion{
    private int[] id;
    private int[] sz;
    QuickUnion(int N){
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }
    private int root(int i){
        while(i!=id[i]){
            id[i]=id[id[i]];
            i=id[i];
        }
        return i;
    }
    boolean connected(int p,int q){
        return root(p)==root(q);
    }
    void union(int p,int q){
        int i=root(p);
        int j=root(q);
        if(sz[i]>sz[j]){
            id[j]=i;
            sz[i]+=sz[j];
        }
        else{
            id[i]=j;
            sz[j]+=sz[i];
        }
    }
}
class TQU{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of array");
        int n=Integer.parseInt(br.readLine());
        QuickUnion qu=new QuickUnion(n);
        while(true){
            String s=br.readLine();
            if(s.isEmpty()){break;}
            System.out.println("Enter nodes to be connrcted");
            String[] sp=s.split(" ");
            int a=Integer.parseInt(sp[0]);
            int b=Integer.parseInt(sp[1]);
            if(!qu.connected(a,b)){
                qu.union(a,b);
                System.out.println("Connected "+a+" "+b);
        }
    }
}
}