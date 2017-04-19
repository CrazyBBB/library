package crazybbb;

public class RangeMaximumQuery {
    int n;
    int[] dat;

    public RangeMaximumQuery(int n1) {
        n = 1;
        while (n < n1) {
            n <<= 1;
        }
        dat = new int[2 * n - 1];
    }

    public void update(int k, int a) {
        k += n - 1;
        dat[k] = a;
        while (k > 0) {
            k = (k - 1) / 2;
            dat[k] = Math.max(dat[k * 2 + 1], dat[k * 2 + 2]);
        }
    }

    public int query(int a, int b) {
        return query(a, b + 1, 0, 0, n);
    }

    private int query(int a, int b, int k, int l, int r) {
        if (r <= a || b <= l) return 0;

        if (a <= l && r <= b) return dat[k];

        int vl = query(a, b, k * 2 + 1, l, (l + r) / 2);
        int vr = query(a, b, k * 2 + 2, (l + r) / 2, r);
        return Math.max(vl, vr);
    }
}
