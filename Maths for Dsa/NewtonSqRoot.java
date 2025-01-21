//Newton raphson method used to find better approximate for roots of real valued


public class NewtonSqRoot{
    public static void main(String[] args){
        System.out.println(sqrt(25));

    }

    static double sqrt(double n){
        double x=n;
        double root;
        while(true){
            root=0.5* (x +(n/x));//formula
            if(Math.abs(root-x)<0.01){// cal absolute value
                break;
            }
            x=root;
        }
        return root;

    }
}