import java.io.*;
class Selection{
    public void sort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int min=arr[i];
            for(int j=i+1;j<n;j++){
                if(min>arr[j]) {
                min=arr[j];
                int temp=arr[i];
                arr[i]=min;
                arr[j]=temp;}
            }    
        }
        System.out.println("Output is :");
        show(arr);
    }
    private void show(int arr[]){for(int i=0;i<arr.length;i++)
        System.out.println(arr[i]);}
}
class UseSelection{
    public static void main(String[] args) throws IOException{
        Selection s=new Selection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of elements");
        int a=Integer.parseInt(br.readLine());
        int arr[]=new int[a];
        System.out.println("Enter elements");
        for(int i=0;i<a;i++) arr[i]=Integer.parseInt(br.readLine());
        s.sort(arr);
    }
}