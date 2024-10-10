public class OrderAgnosticBS{
    public static void main(String[] args) {
        int[] arr={1,3,4,6,7,9,12,16,18,25,36,48,59,65,88};
        int target=25;
        int Ans=orderagnostic(arr, target);
        System.out.println(Ans);
    }
    static int orderagnostic(int[] arr,int target){
        
        int start=0;
        int end=arr.length-1;

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
