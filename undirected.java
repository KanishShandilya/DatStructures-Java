import java.io.*;
class Bag{
    int value;
    Bag next;
    Bag(){next=null;}
}
class UD{
    Bag [] adj;
    int v;
    int e;
    UD(int v){
        this.v=v;
        this.e=0;
        adj=new Bag[v];
        for(int i=0;i<v;i++){
            adj[i]=new Bag();
            adj[i].value=i;
        }
    }
    int vertices(){
        return v;
    }
    int edges(){
        return e;
    }
    void add_Edge(int x,int y){
        Bag i=adj[x];
        if(i.value==y){System.out.println("Already Exists");return;}
        while(i.next!=null) {
            if(i.next.value==y){
                System.out.println("Already Exists");
                return;
            }
            i=i.next;
        }
        i.next=new Bag();
        i.next.value=y;

        Bag j=adj[y];
        while(j.next!=null) j=j.next;
        j.next=new Bag();
        j.next.value=x;

        e++;
    }
    void display(){
        for(int i=0;i<v;i++){
            Bag x=adj[i];
            while(x!=null){
                System.out.println(adj[i].value+"-------"+x.value);
                x=x.next;
            }
        }
    }
}
class DFS{
    boolean marked[];
    int edgeTo[];
    int s;
    DFS(UD obj,int s){
        marked=new boolean[obj.adj.length];
        edgeTo=new int[obj.adj.length];
        for(int i=0;i<edgeTo.length;i++) edgeTo[i]=-1;
        this.s=s;
        dfs(obj.adj,s);
    }
    void dfs(Bag G[],int v){
        marked[v]=true;
        for(Bag x=G[v].next;x!=null;x=x.next){
            if(!marked[x.value]){
                marked[x.value]=true;
                edgeTo[x.value]=v;
                dfs(G,x.value);
            }
        }
    }
    void display(){
        for(int i=0;i<marked.length;i++){
            System.out.println(marked[i]+"\t"+edgeTo[i]);
        }
    }
    boolean hasPathTo(int v){
        return marked[v];
    }
    void pathTo(int v){
        if(!marked[v]) {System.out.println("No Path");return;}
        for(int i=v;i!=-1 && i!=s;){
            System.out.println(i);
            i=edgeTo[i];
        }
    }
}
class BFS{
    Queue qu;
    boolean marked[];
    int edgeTo[];
    int s;
    BFS(UD obj,int s){
        qu=new Queue(obj.adj.length);
        marked=new boolean[obj.adj.length];
        edgeTo=new int[obj.adj.length];
        for(int i=0;i<obj.adj.length;i++) edgeTo[i]=-1;
        this.s=s;
        bfs(obj.adj,s);
    }
    void bfs(Bag adj[],int v){
        qu.enqueue(v);
        marked[v]=true;
        while(!qu.isEmpty()){
            int t=qu.dequeue();
            Bag x=adj[t];
            for(;x!=null;x=x.next){
                if(!marked[x.value]){
                    qu.enqueue(x.value);
                    marked[x.value]=true;
                    edgeTo[x.value]=t;
                }
            }

        }
    }
    void display(){
        for(int i=0;i<marked.length;i++){
            System.out.println(i+"=>"+edgeTo[i]+"--------------"+marked[i]);
        }
    }
}
class Queue{
    int arr[];
    int front;
    int rear;
    Queue(int n){
        arr=new int[n];
        front=-1;
        rear=-1;
    }
    void enqueue(int n){
        if(front==-1 && rear==-1){arr[++rear]=n;front++;}
        else{arr[++rear]=n;}
    }
    int dequeue(){
        if(front==rear){int n=front;rear=front=-1;return arr[n];}
        return arr[front++];
    }
    boolean isEmpty(){
        if(front==-1 && rear==-1) return true;
        return false;
    }
}
class CC{
    boolean marked[];
    int id[];
    int count;

    CC(UD obj){
        marked=new boolean[obj.adj.length];
        id=new int[obj.adj.length];
        for(int i=0;i<obj.adj.length;i++){
            if(!marked[i]){
                dfs(obj.adj,i);
                count++;
            }
        }
    }
    void dfs(Bag g[],int v){
        marked[v]=true;
        id[v]=count;
        Bag x=g[v];
        for(;x!=null;x=x.next){
            if(!marked[x.value]) dfs(g,x.value);
        }
    }
    void display(){
        for(int i=0;i<id.length;i++){
            System.out.println(i+"    "+id[i]+"    ->    "+marked[i]);
        }
    }
}
class UseUG{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number Of vertices");
        int x=Integer.parseInt(br.readLine());
        UD obj=new UD(x);
        while(true){
            System.out.println("Enter Nothing to exit else press e");
            String s=br.readLine();
            if(s.isEmpty()) break;
            System.out.println("Enter 1st Vertex");
            int i=Integer.parseInt(br.readLine());
            System.out.println("Enter 2nd Vertex");
            int j=Integer.parseInt(br.readLine());
            obj.add_Edge(i, j);
        }
        System.out.println("Number Of vertices ->"+obj.vertices());
        System.out.println("Number Of Edges ->"+obj.edges());
        obj.display();
        // System.out.println("\n");
        // System.out.println("Enter Vertex for DFS");
        // int i=Integer.parseInt(br.readLine());
        // DFS obj1=new DFS(obj,i);
        // while(true){
        //     System.out.println("Enter Nothing to exit else press e");
        //     String s=br.readLine();
        //     if(s.isEmpty()) break;
        //     System.out.println("Enter Vertex");
        //     int p=Integer.parseInt(br.readLine());

        //     obj1.pathTo(p);
        // }
        // System.out.println("\n");
        // System.out.println("Enter Vertex for DFS");
        // int i=Integer.parseInt(br.readLine());
        // BFS o=new BFS(obj,i);
        // o.display();
        CC ob=new CC(obj);
        ob.display();
    }
}