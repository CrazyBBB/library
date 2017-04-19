package crazybbb;

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

    public long combMod(int a, int b) {
        long ret = nors[a];
        ret = modulo.mlt(ret, revs[b]);
        ret = modulo.mlt(ret, revs[a - b]);
        return ret;
    }
}
