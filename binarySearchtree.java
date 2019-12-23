import java.io.*;

class BST{
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
    void put(int key,String value){
        root=put(root,key,value);
    }
    private Node put(Node x,int key,String value){
        if(x==null) return new Node(key,value);
        int r=compare(key,x.key);
        if(r<0){
            x.left=put(x.left,key,value);
        }
        else if(r>0){
            x.right=put(x.right,key,value);
        }
        else{
            x.value=value;
        }
        return x;
    }
    String get(int key){
        Node x=root;
        while(x!=null){
            int r=comapare(key,x.key);
            if(r<1){
                x=x.left;
            }
            else if(r>1){
                x=x.right;
            }
            else{
                return x.value;
            }
        }
        return null;
    }
    // Min Key
    void min(){
        root=min(root);
    }
    private Node min(Node x){
        if(x.left==null) return x;
        x.left=min(x.left);
        return x;
    }
    //Max key
    void max(){
        root=max(root);
    }
    Node max(Node x){
        if(x.right==null) return x;
        x.right=max(x.left);
        return x;
    }
    //Compare
    int compare(int k,int k1){
        if(k>k1) return 1;
        else if(k<k1) return -1;
        else return 0;
    }
    //DeleteMin
    void deletemin(){
        root=deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left==null) return x.right;
        x.left=deleteMin(x.left);
        return x;
    }
    //DeleteMax
    void deleteMax(){
        root=deleteMax(root);
    }
    private Node deleteMax(Node x){
        if(x.right==null) return x.left;
        x.right=deleteMax(x.right);
        return x;
    }
    //Hibbard Deletion
    void delete(int key){
        root=delete(root,key);
    }
    private Node delete(Node x,int key){
        if(x==null) return null;
        int r=compare(key,x.key);
        if(r<1) x.left=delete(x.left,key);
        else if(r>1) x.right=delete(x.right,key);
        else{
            if(x.right==null) return x.left;
            if(x.right==null) return x.right;
            Node t=x;
            x=min(t.right);
            x.right=deleteMin(t.right);
            x.left=t.left;
        }
        return x;
    }
    //Calculating Floor
    int floor(int key){
        Node x=floor(root,key);
        if(x==null) return 0;
        else return x.key;
    }
    private Node floor(Node x,int key){
        if(x==null) return null;
        int r=compare(key,x.key);
        if(r==0) return x;
        if(r<0) return floor(x.left,key);
        Node t=floor(x.right,key);
        if(t!=null) return t;
        else return x;
    }
    //Calculating Ceiling
    int ceiling(int key){
        Node x=ceiling(root,key);
        if(x==null) return 0;
        else return x.key;
    }
    private Node ceiling(Node x,int key){
        if(x==null) return null;
        int r=compare(key,x.key);
        if(r==0) return x;
        if(r>0) return ceiling(x.right,key);
        Node t=ceiling(x.left, key);
        if(t!=null) return t;
        else return x;
    }
}
class UseBST{
    public static void main(String[] args) throws IOException{
        BST obj=new BST();
        obj.put(12,"Five");
        obj.put(13,"Th");
        obj.put(2,"Two");
        System.out.println(obj.floor(11));
    }
}