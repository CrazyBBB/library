package crazybbb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Napsack {
    public static long solveSmallW(int n, int W, int[] v, int[] w) {
        long[] dp = new long[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= 0; j--) {
                if (j + w[i] > W) continue;

                dp[j + w[i]] = Math.max(dp[j + w[i]], dp[j] + v[i]);
            }
        }
        return dp[W];
    }

    public static long solveSmallV(int n, int W, int[] v, int[] w) {
        int vSum = 0;
        for (int i = 0; i < n; i++) {
            vSum += v[i];
        }

        long[] dp = new long[vSum + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = vSum; j >= 0; j--) {
                if (dp[j] == Long.MAX_VALUE) continue;
                if (j + v[i] > vSum) continue;

                dp[j + v[i]] = Math.min(dp[j + v[i]], dp[j] + w[i]);
            }
        }

        long ans = 0;
        for (int i = vSum; i >= 0; i--) {
            if (dp[i] <= W) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static long solveSmallN(int n, int W, int[] v, int[] w) {
        int n1 = n / 2;
        int[] v1 = new int[n1];
        int[] w1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            v1[i] = v[i];
            w1[i] = w[i];
        }

        int n2 = n - n / 2;
        int[] v2 = new int[n2];
        int[] w2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            v2[i] = v[n1 + i];
            w2[i] = w[n1 + i];
        }

        List<Pair> tmp = new ArrayList<>();
        for (int i = 0; i < 1 << n1; i++) {
            long v1Sum = 0;
            long w1Sum = 0;
            for (int j = 0; j < n1; j++) {
                if ((i >> j & 1) == 1) {
                    v1Sum += v1[j];
                    w1Sum += w1[j];
                }
            }
            tmp.add(new Pair(v1Sum, w1Sum));
        }

        Collections.sort(tmp);
        long maxV = -1;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            Pair p = tmp.get(i);
            if (maxV >= p.v) continue;

            list.add(p);
            maxV = Math.max(maxV, p.v);
        }

        long ans = 0;
        for (int i = 0; i < 1 << n2; i++) {
            long v2Sum = 0;
            long w2Sum = 0;
            for (int j = 0; j < n2; j++) {
                if ((i >> j & 1) == 1) {
                    v2Sum += v2[j];
                    w2Sum += w2[j];
                }
            }

            int idx = upperBound(list, new Pair(0, W - w2Sum)) - 1;
            if (idx < 0) continue;
            long v1Sum = list.get(idx).v;
            ans = Math.max(ans, v1Sum + v2Sum);
        }

        return ans;
    }

    public static class Pair implements Comparable<Pair> {
        long v, w;

        Pair(long v, long w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Pair p) {
            return w == p.w ? -Long.compare(v, p.v) : Long.compare(w, p.w);
        }
    }



    static int upperBound(List<Pair> list, Pair x) {
        int high = list.size();
        int low = 0;
        while (high > low) {
            int mid = (high + low) / 2;
            if (list.get(mid).compareTo(x) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
