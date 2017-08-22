package crazybbb;

import java.util.*;

public class ArrayUtils {
    public static void fill(long[][] array, long x) {
        for (long [] a : array) {
            Arrays.fill(a, x);
        }
    }

    public static void fill(long[][][] array, long x) {
        for (long[][] a : array) {
            fill(a, x);
        }
    }

    public static void fill(int[][] array, int x) {
        for (int [] a : array) {
            Arrays.fill(a, x);
        }
    }

    public static void fill(int[][][] array, int x) {
        for (int[][] a : array) {
            fill(a, x);
        }
    }

    public static void decreaseByOne(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i]--;
        }
    }

    public static void decreaseByOne(int[][] array) {
        for (int[] a : array) {
            decreaseByOne(a);
        }
    }

    public static void decreaseByOne(long[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i]--;
        }
    }

    public static void decreaseByOne(long[][] array) {
        for (long[] a : array) {
            decreaseByOne(a);
        }
    }

    public static int lowerBound(int[] a, int x) {
        int high = a.length;
        int low = 0;
        while (high > low) {
            int mid = (high + low) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(int[] a, int x) {
        int high = a.length;
        int low = 0;
        while (high > low) {
            int mid = (high + low) / 2;
            if (a[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * i番目まで要素のうちk個の要素の和の最大値を表す配列を計算する
     * @param array 非負数の配列
     * @param k k
     * @return 各iでの和の最大値の配列
     */
    public static long[] calcMaxSum(long[] array, int k) {
        int n = array.length;
        long[] ret = new long[n];

        long sum = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (queue.size() < k) {
                queue.add(array[i]);
                sum += array[i];
            } else {
                long min = queue.peek();
                if (array[i] > min) {
                    queue.poll();
                    queue.add(array[i]);
                    sum += array[i] - min;
                }
            }
            ret[i] = sum;
        }

        return ret;
    }

    /**
     * i番目まで要素のうちk個の要素の和の最小値を表す配列を計算する
     * @param array 非負数の配列
     * @param k k
     * @return 各iでの和の最小値の配列
     */
    public static long[] calcMinSum(long[] array, int k) {
        int n = array.length;
        long[] ret = new long[n];

        long sum = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (queue.size() < k) {
                queue.add(array[i]);
                sum += array[i];
            } else {
                long max = queue.peek();
                if (array[i] < max) {
                    queue.poll();
                    queue.add(array[i]);
                    sum -= max - array[i];
                }
            }
            ret[i] = sum;
        }

        return ret;
    }

    public static long[] calcCumulativeSum0First(long[] array) {
        int n = array.length;
        long[] ret = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ret[i + 1] = array[i];
            ret[i + 1] += ret[i];
        }
        return ret;
    }

    /**
     * 配列arrayのfromからtoの和を返す
     * from > to の場合も可
     * @param array 配列
     * @param from from
     * @param to to
     * @return 和
     */
    public static long rangeSum(int[] array, int from, int to) {
        if (from > to) {
            int tmp = from;
            from = to;
            to = tmp;
        }

        long ret = 0;
        for (int i = from; i <= to; i++) {
            ret += array[i];
        }

        return ret;
    }

    public static int max(int[] array) {
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret = Math.max(ret, array[i]);
        }

        return ret;
    }

    public static int maxIndex(int[] array) {
        int ret = 0;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                ret = i;
                max = array[i];
            }
        }

        return ret;
    }

    public static Map<Integer, Integer> getCountMap(int[] array) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : array) map.merge(x, 1, Integer::sum);
        return map;
    }
}
