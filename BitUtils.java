package crazybbb;

import java.util.ArrayList;
import java.util.List;

public class BitUtils {
    public static List<Integer> getSubset(int x) {
        int t = x;
        ArrayList<Integer> subset = new ArrayList<>();
        do {
            subset.add(t);
            t = (t - 1) & x;
        } while (t != x);
        return subset;
    }

    public static List<Integer> getSubset(int n, int k) {
        ArrayList<Integer> subset = new ArrayList<>();
        int t = (1 << k) - 1;
        while (t < 1 << n) {
            subset.add(t);

            int p = t & -t;
            int q = t + p;

            t = ((t & ~q) / p >>> 1) | q;
        }
        return subset;
    }
}
