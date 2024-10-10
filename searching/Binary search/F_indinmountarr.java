
public class F_indinmountarr{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,3,1};
        int target=3;
        System.out.println(search(arr,target));
    }
        static int search(int[] arr,int target){
        int peak=Peakindex(arr);
        int firsttry=orderagnostic(arr, target,0,peak);
        if(firsttry!=-1){
            return firsttry;
        }
        else{
            return orderagnostic(arr, target, peak+1,arr.length-1);
        }
        

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
    static int orderagnostic(int[] arr,int target,int start,int end){
        
        
        boolean isAsc=arr[start]<arr[end];

        while(start<=end){
        int mid= start +(end-start)/2;

        if(arr[mid]==target){
            return mid;
        }
        if (isAsc){
          if(target<arr[mid]){
            end=mid-1;
            }
          else if(target>arr[mid]){
                start=mid +1;
            }
            }
          else{
                if(target>arr[mid]){
                end=mid-1;
            }
                else if(target<arr[mid]){
                start=mid +1;
            }
            }
        }
        
        return -1;
    }
   

}