
public class Minnum{
    public static void main(String[] args) {
        int[] arr={18,12,-7,3,14,28};
        System.out.println(min(arr));
    }
    static int min(int[] arr){
        int minnum=arr[0];
        for(int num : arr){
            if(num<minnum){
                minnum=num;
            }
        }
        return minnum;
        

    }
}