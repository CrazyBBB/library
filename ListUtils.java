package crazybbb;

import java.util.List;

public class ListUtils {

    public static int lowerBound(List<Comparable> list, Comparable x) {
        int high = list.size();
        int low = 0;
        while (high > low) {
            int mid = (high + low) / 2;
            if (list.get(mid).compareTo(x) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(List<Comparable> list, Comparable x) {
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
