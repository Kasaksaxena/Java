// leetcode 852
public class MountainArr{
    public static void main(String[] args) {
        int[] arr={0,1,3,6,7,4,2};
        System.out.println(Peakindex(arr));

    }
    static int Peakindex(int[] arr){
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int mid=start+(end-start)/2;

            if(arr[mid]<arr[mid+1]){
            // asc part of //we know mid+1>mid    
                start=mid+1;
            }
            else {
                //desc part of arr/ we dont know
                // mid+1 > mid or not
                end=mid;
            }    

            
        }
        return start;// when start=end // u can return end as well
    }
}