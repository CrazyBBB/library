package crazybbb;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ArrayUtils {

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
}
