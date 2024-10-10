public class InfiniteArr{
    public static void main(String[] args) {
        int[] arr={1,2,5,9,12,14,15,19,21,25,27,30,32,36,40,45};
        int target=19;
        System.out.println(ans(arr,target));

    }
    static int ans(int[] arr,int target){
        
        int start=0;
        int end=1;
        

        while(target>arr[end]){
            int nstart=end+1;
            end=end+(end-start +1) * 2;
            start=nstart;
        }

        return Binarysearch(arr, target, start, end);


    }
    static int Binarysearch(int[] arr,int target,int start,int end){

        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>arr[mid]){
                start=mid+1;}
            else if(target<arr[mid]){
                end=mid-1;
            }  
            else{
                return mid;
            }  
        }
       return -1; 
    }
}