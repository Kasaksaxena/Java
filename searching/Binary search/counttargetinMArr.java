public class counttargetinMArr{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,3,1};
        int target=3;
        int Ans1=count(arr,target,true);
        System.out.println(Ans1);
        int Ans2=count(arr,target,false);
         System.out.println(Ans2);
        int ans= Ans1+Ans2;
        System.out.println(ans);


    }
    static int MountainArr(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }
            else{
                end=mid;
            }    

            
        }
       return start;
    }
    
    static int count(int[] arr,int target,boolean decsearch){
        int count=0;
         int peakvalue=MountainArr(arr);
         System.out.println(peakvalue);
         
        if(decsearch==true){
            int start=0;
            int end=peakvalue-1;
            int ans=Binarysearch( arr,target,start,end);
            if(ans!=-1){
                count+=1;
            }
            else{
                return count;
            }
        }
        else{
            int start=peakvalue;
            int end=arr.length-1;
            int ans=Binarysearch(arr,target,start,end);
            
            if(ans!=-1){
                count+=1;
            }
            else{
                return count;
            }

        }
        return count;



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