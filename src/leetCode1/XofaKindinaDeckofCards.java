package leetCode1;

import java.util.Arrays;

public class XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;

        int[] cnt = new int[10001];
        for (int num : deck) {
            cnt[num]++;
        }

        int index = 0;
        while (index < cnt.length && cnt[index] < 2) {
            if (cnt[index] == 1) return false;
            index++;
        }

        int gcd = cnt[index];

        for (index += 1; index < cnt.length; index++) {
            if (cnt[index] == 1) return false;

            if (cnt[index] > 0) {
                int fake = findGCD(cnt[index], gcd);
                if (fake == 1) return false;
                gcd = fake;
            }
        }

        return true;
    }

    private int findGCD(int a, int b) {
        return a == 0 ? b : findGCD(b % a, a);
    }
}
