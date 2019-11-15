import java.io.*;
class Insertion{
    void sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        System.out.println("Output is:");
        show(arr);
    }
    private void show(int[] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
class UseInsertion{
    public static void main(String[] args) throws IOException{
        Insertion i=new Insertion();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter length of array");
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        System.out.println("Enter Elements");
        for(int j=0;j<n;j++){
            arr[j]=Integer.parseInt(br.readLine());
        }
        i.sort(arr);
    }
}