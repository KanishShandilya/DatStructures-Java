class RBBST{
    public static final boolean RED=true;
    public static final boolean BLACK=true;
    Node root;
    private class Node{
        Node left;
        Node right;
        int key;
        String value;
        boolean color;
        Node(int key,String value){
            this.key=key;
            this.value=value;
            this.color=RED;
        }
    }
    boolean isRed(Node x){
        if(x==null) return false;
        return x.color==RED;
    }
    int compare(int a,int b){
        if(a>b) return 1;
        else if(a<b) return -1;
        else return 0;
    }
    String get(int h){
        Node x=root;
        while(x!=null){
            int r=compare(h, x.key);
            if(r>0) x=x.right;
            else if(r<0) x=x.left;
            else return x.value;
        }
        return null;
    }
    Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        return x;
    }
    Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        return x;
    }
    void flipColor(Node h){
        h.color=RED;
        h.right.color=BLACK;
        h.left.color=BLACK;
    }
    void put(int key,String value){
        root=put(root,key,value);
    }
    Node put(Node x,int key,String value){
        if(x==null) return new Node(key,value);
        int r=compare(key,x.key);
        if(r>0) put(x.right,key,value);
        else if(r<0) put(x.right,key,value);
        else x.value=value;
        if(!isRed(x.left) && isRed(x.right))
            x=rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left))
            x=rotateRight(x);
        if(isRed(x.right) && isRed(x.left))
            flipColor(x);
        return x;
    }
}
