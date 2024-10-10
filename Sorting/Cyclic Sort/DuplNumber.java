public class DuplNumber{
    public static void main(String[] args) {
        int[] arr={2,2,2,2,2};
        int ans=Cyclesort(arr);
        System.out.println(ans);
    }
    static int Cyclesort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]==arr[correct]){
                i++; 
                }
            else{
                swap(arr,i,correct);
            }  
        }
            for(int index=0;index<arr.length;index++){
                if(arr[index]!=index+1){
                    return arr[index];
                }
            }
            return -1;  

        
    }

    static void swap(int[]arr , int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
 
