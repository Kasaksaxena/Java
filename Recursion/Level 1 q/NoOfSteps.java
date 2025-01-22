// leetcode q 1342
public class NoOfSteps{
    public static void main(String[] args) {
        int num=14;
        System.out.println(steps(num));
        
    }

    static int steps(int num){
        return helper(num,0);
    }

    private static int helper(int num, int steps){
        if(num==0){
            return steps;
        }
        if(num %2==0){
            return(helper(num/2,steps+1));
        }
        return helper(num-1,steps+1);
    }
}