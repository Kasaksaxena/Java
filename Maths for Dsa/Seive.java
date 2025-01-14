// also called sieve of Eratosthenas

public class Seive{
    public static void main(String[] args) {
        int n=40;
        boolean[] primes= new boolean[n+1];
// initially all values i primes[] set to false,which means every no. is considered as prime        
        sieve(n,primes);

    }
    // false in array means number is prime
    static void sieve(int n, boolean [] primes){
    // iterates over 2 to sq root of n    
        for (int i = 2; i*i<=n; i++) {
    //if prime[i] is false only then
            if(!primes[i]){
    // marks all multiple of i as true            
                for(int j=i*2; j<=n;j+=i){
                    primes[j]=true;

                }

            }
            
        }
 //   printing final prime number
        for (int i = 2; i <=n; i++) {
            if(!primes[i]){
                System.out.print(i + " ");
            }
            
        }
    }
}