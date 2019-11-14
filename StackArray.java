import java.io.*;
class StackA{
    String arr[]=new String[1];
    int top;
    StackA(){top=-1;}
    void resize(int ar){
        String a[]=new String[ar];
        for(int i=0;i<=top;i++){
            a[i]=arr[i];
        }
        arr=a;
        System.out.println("Array Resized");
    }
    void push(String a){
        if(top==(arr.length-1))
        resize((arr.length*2));
        arr[++top]=a;
    }
    String pop(){
        if(top>0 && top==arr.length/4) resize(arr.length/2);
        String q=arr[top--];
        arr[top+1]=null;
        return q;
    }
    void show(){
        for(int i=top;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
}
class UseStackA{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StackA obj=new StackA();
        while(true){
            String s=br.readLine();
            if(s.isEmpty()) break;
            else if(s.isBlank()){
                String q=obj.pop();
                System.out.println(q);
            }
            else{
                obj.push(s);
            }
        }
        obj.show();
    }
}