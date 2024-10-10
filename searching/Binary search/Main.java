public class Main{
    public static void main(String[] args) {
        int[] arr={1,3,4,6,7,9,12,16,19,21,25,32,45,78};
        int target=19;
        int Ans=Binarysearch(arr, target);
        System.out.println(Ans);
    }

    static int Binarysearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        

        while(start<=end){
            int mid= start +(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}