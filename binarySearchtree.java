import java.io.*;

class BinarySearchTree{
    Node root;
    private class Node{
        Node left;
        Node right;
        int key;
        String value;
        Node(int key,String value){
            this.key=key;
            this.value=value;
        }
    }
    void put(int key,String val){
        root=put(root,key,val);
    }
    private Node put(Node x,int k,String v){
        if(x==null) return new Node(k,v);
        int r=compare(k,x.key);
        if(r<0)
            x.left=put(x.left,k,v);
        else if(r>0)
            x.right=put(x.right,k,v);
        else
            x.value=v;
        return x;
    }
    Node get(int key){
        Node x=root;
        while(x!=null){
            int r=compare(key,x.key);
            if(r<0) x=x.left;
            else if(r>0) x=x.right;
            else return x;
        }
        return null;
    }
    void min(){
        Node x=root;
        if(x==null)
            System.out.println("No key to be displayed\nEmpty Tree");
        else{
            while(x.left!=null){
                x=x.left;
            }
            System.out.println("Minimum Key\n"+x.key);
        }
    }
    void max(){
        Node x=root;
        if(x==null)
            System.out.println("No key to be displayed\nEmpty Tree");
        else{
            while(x.right!=null){
                x=x.right;
            }
            System.out.println("Max Key\n"+x.key);
        }
    }
    int compare(int k,int v){
        if(k>v) return 1;
        else if(k<v) return -1;
        else return 0;
    }
}
class UseBST{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree obj=new BinarySearchTree();
        
        while(true){
            System.out.println("ENter nothing to exit and e for new entry");
            if(br.readLine().isEmpty()) break;
            System.out.println("Enter Key");
            int v=Integer.parseInt(br.readLine());
            System.out.println("Enter Value");
            String k=br.readLine();
            obj.put(v,k);
        }
        obj.min();
        obj.max();
    }
}