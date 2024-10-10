public class Rotatedarray{
    public static void main(String[] args) {
        int[] arr={4,5,6,0,1,2,3};
        int target=4;
        System.out.println(search(arr,target));
}
    static int search(int[] arr,int target){
        int pivot=findpivot(arr);
        int start=0;
        
        
        if(pivot==-1){
            // do normal binary search
            return Binarysearch(arr, target, 0, arr.length-1);
        }
        if(target==arr[pivot]){
            return pivot;
        }
        if(target>=arr[start]){
            return Binarysearch(arr, target, 0, pivot-1);
        }
        else{
            return Binarysearch(arr,target,pivot+1,arr.length-1);
        }

        

        
    }
    static int findpivot(int[]arr){
        int start=0;
        int end= arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            //4cases over there
            if(mid<end &&arr[mid]>arr[mid+1]){
                return mid;}
            if(mid>start &&arr[mid]<arr[mid-1]){
                return mid-1;}
            if(arr[mid]<= arr[start]){
                end=mid-1;}
              
              else{
                start=mid+1;
               }  

                

        }
        return -1;
    }
    static int Binarysearch(int[] arr,int target,int start,int end){
        

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