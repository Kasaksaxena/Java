public class SplitArr{
    public static void main(String[] args) {
        int[] arr={7,2,5,8,10};
        int m=2;
        System.out.println(Splitarr(arr, m));
    }
    static int Splitarr(int[] arr,int m){
        int start=0;
        int end=0;
        for (int i = 0; i < arr.length; i++) {
            start=Math.max(start,arr[i]);
            end+=arr[i];
            
        }

        while(start<end){
            int mid=start+(end-start)/2;

            // calculate how many pieces u can get

            int sum=0;
            int pieces=1;
            for (int num : arr) {
                if(sum+num>mid){
                    sum=num;
                    pieces++;
                }
                else{
                    sum+=num;
                }
            }
                if(pieces<=m){
                    end=mid;

                }
                else{
                    start=mid+1;
                }
                
            

        }
        return start;
    }
    
}