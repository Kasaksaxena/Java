public class Linearsearch{
    public static void main(String[] args){
        int[] arr={1,3,6,9,8,14,25,36,21,19};
        int target=25;
     int index=0;
     System.out.println(find(arr,target,index));
     System.out.println(findIndex(arr,target,index));


    }

    static boolean find(int[] arr,int target,int index){
        if(index== arr.length){
            return false;
        }
        return arr[index]==target || find(arr,target,index+1);
    }

    static int findIndex(int[] arr,int target,int index){
        if(index== arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return findIndex(arr,target,index+1);

    }
}