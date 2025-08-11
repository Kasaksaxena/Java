// leetcode 875
import java.util.Arrays;
public class KokoEatingBananas{
    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int h=8;
        int result=minEatingspeed(piles,h);
        System.out.println("\n Minimum eating speed:" + result +"bananas/hour");
    }
    public static int minEatingspeed(int[] piles, int h){
        int left=1;
        int right=Arrays.stream(piles).max().getAsInt();
        while(left<right){
            int mid= left + (right-left)/2;
            if(canFinish(piles,h,mid)){
                right=mid;// try smaller speed
            }else{
                left=mid+1;// try faster speed
            }
        }
        return left; // or right(both are same)
    }
     private static boolean canFinish(int[] piles, int h, int mid){
        long hours=0;
        for(int pile :piles){
            long timeforpile=(pile + mid -1)/mid;//cell division(for remainder its imp)
            hours+=timeforpile;
            if(hours>h)return false;// stop early
        }
        return hours <=h;

     }

}