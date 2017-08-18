package crazybbb;

import java.math.BigInteger;

public class Combination {
    Modulo modulo;
    long[] nors, revs;

    public Combination(int n, long m) {
        nors = new long[n + 1];
        revs = new long[n + 1];
        modulo = new Modulo(m);

        nors[0] = 1;
        for (int i = 1; i <= n; i++) {
            nors[i] = modulo.mlt(nors[i - 1], i);
        }

        revs[n] = modulo.rev(nors[n]);
        for (int i = n - 1; i >= 0; i--) {
            revs[i] = (revs[i + 1] * (i + 1)) % m;
        }
    }

    public long combMod(int n, int k) {
        long ret = nors[n];
        ret = modulo.mlt(ret, revs[k]);
        ret = modulo.mlt(ret, revs[n - k]);
        return ret;
    }

    public static long combSimple(int n, int k) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            ret = ret.multiply(BigInteger.valueOf(n - i));
        }
        for (int i = 1; i <= k; i++) {
            ret = ret.divide(BigInteger.valueOf(i));
        }
        return ret.longValue();
    }
}
