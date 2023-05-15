package leetcode;
/*
* Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)

Since the answer may be large, return the answer modulo 10^9 + 7.
* */
public class PrimeNumbers {
    /*public static int helper(int n){
        int count = 0;
        int[]arr = new int[n+1];
        for(int i = 2;i <n+1;i++){
            for(int j = i + i;j <= n;j += i){
                arr[j] = 1;
            }
        }
        for(int i = 2;i<=n;i++){
            if(arr[i] == 0){
                count++;
            }
        }
        return count;
    }*/
    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so
        // that we can skip
        // middle five numbers
        // in below loop
        if (n % 2 == 0 ||
                n % 3 == 0)
            return false;

        for (int i = 5;
             i * i <= n; i = i + 6)
            if (n % i == 0 ||
                    n % (i + 2) == 0)
                return false;

        return true;
    }

    // Function to print primes
    static int CaclPrime(int n)
    {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                count += 1;
        }
        return count;
    }
    public static long fact(int n,long pro){
        for(int i = 2;i<=n;i++){
            pro = pro*i%1000000007;
        }
        return pro;
    }
    public static int numPrimeArrangements(int n) {
        int countPrime = CaclPrime(n);
        long ans = 1;
        ans = fact(countPrime,ans);
        ans = fact(n - countPrime,ans);
        return (int)ans;

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(numPrimeArrangements(n));
    }
}
