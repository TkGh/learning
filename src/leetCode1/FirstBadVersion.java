package leetCode1;

import java.util.*;

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return findPosition(0, n);
    }

    private int findPosition(int lo, int hi) {
        if (hi < lo) {
            return hi + 1;
        }

        int tempFirst = hi + 1;
        int mid = lo + (hi - lo) / 2;
        if (isBadVersion(mid)) {
            tempFirst = findPosition(lo, mid - 1);
        } else {
            tempFirst = findPosition(mid + 1, hi);
        }

        return tempFirst;
    }

    public static void main(String[] args) {
        FirstBadVersion demo = new FirstBadVersion();
        System.out.println(demo.firstBadVersion(10));
    }
}

class VersionControl {
    Random rand = new Random();

    public boolean isBadVersion(int n) {
        if (n >= 10) {
            return true;
        } else {
            return false;
        }
//        return rand.nextBoolean();
    }
}
