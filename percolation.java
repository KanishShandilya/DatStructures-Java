import java.io.*;
class WeightedQuickUnion{
    int id[];
    int size[];
    WeightedQuickUnion(int N){
        id=new int[N];
        size=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            size[i]=1;
        }
    }
    private int root(int N){
        while(N!=id[N])
            N=id[N];
        return N;
    }
    public boolean isConnected(int i,int j){
        return root(i)==root(j);
    }
    public void union(int i,int j){
        int x=root(i);
        int y=root(j);
        if(size[x]>size[y]){
            id[y]=id[x];
            size[x]+=size[y];
        }
        else{
            id[x]=id[y];
            size[y]+=size[x];
        }
    }
}
class Percolate{
    boolean arr[][];
    int top,bottom;
    int size;
    WeightedQuickUnion q;
    Percolate(int N){
        arr=new boolean[N][N];
        top=0;
        size=N;
        bottom=(N*N)+1;
        q=new WeightedQuickUnion((bottom+1));
    }
    public void open(int i,int j){
        arr[i][j]=true;
        if(i==0){
            q.union(top, to1d(i, j));
        }
        if(i==(size-1)){
            q.union(bottom, to1d(i, j));
        }
        if(j>0 && isOpen(i, j-1)){
            q.union(to1d(i, j), to1d(i, j-1));
        }
        if(j<(size-1) && isOpen(i, j+1)){
            q.union(to1d(i, j), to1d(i, j+1));
        }
        if(i>0 && isOpen(i-1, j)){
            q.union(to1d(i, j), to1d(i-1, j));
        }
        if(i<(size-1) && isOpen(i+1, j)){
            q.union(to1d(i, j), to1d(i+1, j));
        }
    }
    public boolean isOpen(int i,int j){
        return arr[i][j]==true;
    }
    private int to1d(int i,int j){
        return (size*i)+j+1;
    }
    public boolean isFull(int i,int j){
        return q.isConnected(to1d(i, j),top);
    }
    public boolean percolates(){
        return q.isConnected(bottom,top);
    }
}
class Percolation{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of grid");
        int n=Integer.parseInt(br.readLine());
        Percolate p=new Percolate(n);
        while(true){
            System.out.println("Enter row and column to be opened with whitespace between them");
            String s=br.readLine();
            if(s.isEmpty()){break;}
            String[] str=s.split(" ");
            int x=Integer.parseInt(str[0]);
            int y=Integer.parseInt(str[1]);
            if(!p.isOpen(x, y)){
                p.open(x, y);
                System.out.println(x+" "+y+" Is Open");
            }
        }
        System.out.println(p.percolates());
    }
}