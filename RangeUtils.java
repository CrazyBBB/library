package crazybbb;

public class RangeUtils {
    public static boolean isInside(int y, int x, int h, int w) {
        return y >= 0 && x >= 0 && y < h && x < w;
    }
}
