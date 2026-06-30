import java.util.*;

class LC918{
    public static  int maxSubarraySumCircular(int[] nums) {

        int total = 0;
        
        // kadan maxsubarr
        int currmax = 0;
        int maxsubarr = Integer.MIN_VALUE;

        // kadan minsubarr
        int currmin = 0;
        int minsubarr = Integer.MAX_VALUE;

        for(int num : nums){
            total+= num;
            
            //max subarr
            currmax = Math.max(num , currmax + num);
            maxsubarr = Math.max(maxsubarr ,currmax);

            // min subarr
            currmin = Math.min(currmin , currmin + num);
            minsubarr = Math.min(currmin , minsubarr);

         }
         if(maxsubarr < 0){
            return maxsubarr;
         }
    return Math.max(maxsubarr , total - minsubarr);  
    }
        public static void main(String[] args) {


        int[][] tests = {
                {1, -2, 3, -2},
                {5, -3, 5},
                {3, -2, 2, -3},
                {-3, -2, -3},
                {8, -1, -3, 8},
                {1, 2, 3},
                {-5},
                {9, -4, -7, 9}
        };

        for (int[] test : tests) {
            System.out.println("Input : " + Arrays.toString(test));
            System.out.println("Answer: " + maxSubarraySumCircular(test));
            System.out.println("-------------------------------");
        }
    }

}

