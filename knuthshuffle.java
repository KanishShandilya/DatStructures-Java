import java.util.Random;
class KnuthShuffle{
    void shuffle(int arr[]){
        for(int i=0;i<arr.length;i++){
            Random ran=new Random();
            int r=ran.nextInt(arr.length-1);
            int temp=arr[i];
            arr[i]=arr[r];
            arr[r]=temp;
        }
        System.out.println("After Shuffling");
        show(arr);
    }
    void show(int arr[]){
        for(int i=0;i<arr.length;i++) System.out.println(arr[i]);
    }
}
class UseShuffle{
    public static void main(String[] args) {
        int arr[]=new int[52];
        for(int i=1;i<=52;i++) arr[i-1]=i;
        KnuthShuffle k=new KnuthShuffle();
        k.shuffle(arr);
    }
}
