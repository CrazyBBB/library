package crazybbb;

public class Modulo {
    long m;

    public Modulo(long m) {
        this.m = m;
    }

    public long add(long a, long b) {
        return (a + b) % m;
    }

    public long sub(long a, long b) {
        return (a - b + m) % m;
    }

    public long mlt(long a, long b) {
        return (a * b) % m;
    }

    public long rev(long a) {
        return pow(a, m - 2);
    }

    public long pow(long a, long x) {
        long ans = 1;
        while (x > 0) {
            if ((x & 1) != 0) {
                ans = (ans * a) % m;
            }
            x >>= 1;
            a = (a * a) % m;
        }
        return ans;
    }

    public long det(long[][] a) {
        int n = a.length;
        long det = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                while (a[j][i] != 0) {
                    long r = a[i][i] / a[j][i];
                    for (int k = i; k < n; k++) {
                        long t = (a[i][k] - r * a[j][k]) % m;
                        a[i][k] = a[j][k];
                        a[j][k] = t;
                    }
                    det = -det;
                }
            }
            det = (det * a[i][i]) % m;
        }
        return det;
    }
}
