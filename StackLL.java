import java.io.*;
class StackLink<Item>{
    Stack first;
    private class Stack{
        Item item;
        Stack next;
    }
    void push(Item str){
            Stack oldFirst=first;
            first=new Stack();
            first.item=str;
            first.next=oldFirst;
    }
    Item pop(){
        Item s=first.item;
        first=first.next;
        return s;
    }
    void show(){
        if(first==null) System.out.println("Stack is Empty");
        else{
        Stack a=first;
        while(a!=null){
            System.out.println(a.item);
            a=a.next;
            }
        }
    }
}
class UseStackLL{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StackLink<Integer> obj=new StackLink<Integer>();
        System.out.println("Enter Integer to be pushed or space key to pop");
        while(true){
            String s=br.readLine();
            if(s.isEmpty()) break;
            else if(s.isBlank()){
                Integer q=obj.pop();
                System.out.println(q+" is poped");
            }
            else{
                obj.push(Integer.parseInt(s));
            }
        }
        obj.show();
    }
}