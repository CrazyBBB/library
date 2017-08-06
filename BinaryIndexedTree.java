package crazybbb;

public class BinaryIndexedTree {
    int n;
    int[] bit;

    public BinaryIndexedTree(int n) {
        this.n = n;
        bit = new int[n + 1];
    }

    public int sum(int i) {
        i++;
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= i & -i;
        }
        return s;
    }

    public void add(int i, int x) {
        i++;
        while (i <= n) {
            bit[i] += x;
            i += i & -i;
        }
    }
}