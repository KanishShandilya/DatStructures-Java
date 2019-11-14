import java.io.*;

class QueueLinked<Item>{
    Queue first;
    Queue last;
    private class Queue{
        Item item;
        Queue node;
    }
    void enqueue(Item s){
        Queue oldlast=last;
        last=new Queue();
        last.item=s;
        last.node=null;
        if(first==null)
        first=last;
        else
        oldlast.node=last;
    }
    Item dequeue(){
        Item q=first.item;
        first=first.node;
        return q;
    }
    void show(){
        Queue a=first;
        while(a!=null){
            System.out.println(a.item);
            a=a.node;
        }
    }
}
class UseQueueL{
    public static void main(String[] args) throws IOException{
        QueueLinked<String> obj=new QueueLinked<String>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String for enqueue and press space key foe dequeue");
        while(true){
            String s=br.readLine();
            if(s.isEmpty()) break;
            else if(s.isBlank()){
                String q=obj.dequeue();
                System.out.println(q+" is Dequeued");
            }
            else obj.enqueue(s);
        }
        obj.show();
    }
}