public class HappyNumber {

    public static boolean isHappy(int n){
        int slow =n;
        int fast = n;
        do {
            slow = sumSquare(slow);
            fast = sumSquare(sumSquare(fast));
        }while( slow !=fast);
        
        return slow == 1;

    }
    private static int sumSquare(int n){
        int sum = 0;
        while( n> 0){
            int digit = n % 10;
            sum+= digit * digit;
            n = n/10;

        }
        return sum;
    }

    public static void main(String args[]){
        int n = 19;
        System.out.println(isHappy(n));
    }
    
}
