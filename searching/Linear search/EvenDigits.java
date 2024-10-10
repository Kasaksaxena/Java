
// leetcode Q1295.find Numbers with even number of digits
public class EvenDigits{
    public static void main(String[] args) {
        int[] nums={12,345,2,6,7896};
        System.out.println(findNumbers(nums));
        
    }
    static int findNumbers(int[] nums){
        int count=0;
        for(int num:nums){
            if(even(num)){
                count++;
            }
        }

        return count;
    }
    // func to check whether a no contains even no of digits
    static boolean even(int num){
        int numberofdigits=digits(num);
        
        return numberofdigits%2==0;

    }

    // count number of digits in a no
    static int digits(int num){
        if(num<0){
            num=num *-1;
        }
        int count =0;
        while(num>0){
            count++;
            num=num/10;
        }
        return count;
    }

    // optimised solution
    static  int digit2(int num){
        if(num<0){
            num=num*-1;
        }
        return (int)(Math.log10(num) +1);

    }
}
