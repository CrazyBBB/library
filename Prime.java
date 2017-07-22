package crazybbb;

import java.util.ArrayList;

public class Prime {
    int n;
    boolean[] isPrime;
    ArrayList<Integer> primes;

    public Prime(int n) {
        this.n = n;
        isPrime = new boolean[n + 1];
        primes = new ArrayList<>();
        sieve();
    }

    private void sieve() {
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                primes.add(i);
                for (long j = (long) i * i; j <= n; j += i) {
                    isPrime[(int) j] = true;
                }
            }
        }
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }
}
