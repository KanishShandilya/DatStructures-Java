class Node{
    int data;
    Node next;
}
class Linked{
    Node head;
    void insert(int data){
        Node n=new Node();
        n.data=data;
        n.next=null;
        if(head==null){
            head=n;
        }
        else{
            Node node=head;
            while(node.next!=null){
                node=node.next;
            }
            node.next=n;
        }
    }
    void insertAtStart(int data){
        Node n=new Node();
        n.data=data;
        n.next=head;
        head=n;
    }
    void insertAt(int index,int data){
        if(index==0){
            insertAtStart(data);
        }
        else{
            Node n=new Node();
            n.data=data;
            n.next=null;
            Node node=head;
            for(int i=0;i<index-1;i++){
                node=node.next;
            }
            n.next=node.next;
            node.next=n;
        }
    }
    void show(){
        Node node=head;
        while(node.next!=null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }
    void delete(int index){
        if(index==0){
            head=head.next;
        }
        else{
            Node node=head;
            Node n1;
            for(int i=0;i<index-1;i++){
                    node=node.next;
            }
            n1=node.next;
            node.next=n1.next;
            n1=null;
        }
    }
}
class LinkedList{
    public static void main(String[] args) {
        Linked m=new Linked();
        m.insert(5);
        m.insert(6);
        m.insert(7);
        m.insertAtStart(4);
        m.insertAt(2, 9);
        m.show();
        m.delete(3);
        m.show();
    }
}