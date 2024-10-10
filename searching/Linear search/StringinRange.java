public class StringinRange{
    public static void main(String[] args) {
        int[] arr={18,23,56,34,29,85,96};
        int target=34;
        int Ans=Linearsearch(arr,target,1,5);
        System.out.println(Ans);


    }
    static int Linearsearch(int[] arr,int target,int start,int end){
        if(arr.length==0){
            return -1;
        }
        for(int i=start;i<=end;i++){
            int element=arr[i];
            if(element==target){
                return i;
            }

        }
        return -1;
    }
}