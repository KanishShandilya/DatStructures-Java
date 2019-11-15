import java.io.*;
class Shell{
    void sort(int[] arr){
        int n=arr.length;
        int h=1;
        h=n/2;
        while(h>0){
            for(int i=h;i<n;i++){
                for(int j=i;j<n;j++){
                    if(arr[j]<arr[j-h]){
                        int temp=arr[j];
                        arr[j]=arr[j-h];
                        arr[j-h]=temp;
                    }
                }
            }
            h=h/2;
        }
        show(arr);
    }
        void show(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
class UseShell{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int arr[]=new int[10];
        for(int i=0;i<10;i++)
        arr[i]=Integer.parseInt(br.readLine());
        Shell s=new Shell();
        s.sort(arr);
    }
}