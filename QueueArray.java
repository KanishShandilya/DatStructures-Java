import java.io.*;
class QueueA{
    String str[]=new String[1];
    int head,tail,no;
    QueueA(){
        head=tail=no=0;
    }
    void resize(int n){
        int i=0;
        String arr[]=new String[n];
        for(i=0;;i++){
            arr[i]=str[head];
            head++;
            if(head==tail) break;
            if(head==str.length) head=0;
        }
        str=arr;
        tail=i+1;
        head=0;
        System.out.println("resized");
    }
    void enqueue(String n){
        if(tail==str.length && head!=0) tail=0;
        else if(tail==head-1 || (tail==str.length && head==0)) resize(str.length*2);
        str[tail]=n;
        tail++;
        no++;
    }
    String dequeue(){
        if(no==str.length/4) resize(str.length/2);
        String q=str[head];
        head++;
        no--;
        return q;
    }
    void show(){
        for(int i=head;;i++){
            if(i==str.length) i=0;
            System.out.println(str[i]);
            if(i==tail-1) break;
        }
    }
}
class UseQueueA{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        QueueA obj=new QueueA();
        while(true){
            String s=br.readLine();
            if(s.isEmpty()) break;
            else if(s.isBlank()){ String q=obj.dequeue();System.out.println(q);}
            else obj.enqueue(s);
        }
        obj.show();
    }
}