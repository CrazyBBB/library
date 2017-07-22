package crazybbb;

public class Euclid {
    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
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
