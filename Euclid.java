package crazybbb;

public class Euclid {
    public static long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public static long gcd(int[] array) {
        long ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret = gcd(ret, array[i]);
        }

        return ret;
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static long lcm(long[] array) {
        long ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret = lcm(ret, array[i]);
        }

        return ret;
    }

    public static int[] extgcd(int a, int b, int[] is) {
        if (a == 0) {
            is[0] = 0;
            is[1] = 1;
            is[2] = b;
        } else {
            extgcd(b % a, a, is);
            int x = is[1] - b / a * is[0];
            is[1] = is[0];
            is[0] = x;
        }
        return is;
    }
}
