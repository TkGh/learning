package leetCode1;

import java.util.Arrays;

public class HIndex {
        public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int length = citations.length;

        Arrays.sort(citations);

        int index = 0;
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length - i) {
                index = length - i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        HIndex test = new HIndex();
        int[] nums = {100};
        System.out.print(test.hIndex(nums));
    }
//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) {
//            return 0;
//        }
//
//        int len = citations.length;
//
//        int[] count = new int[len + 1];
//
//        for (int c : citations) {
//            if (c > len) {
//                count[len]++;
//            } else {
//                count[c]++;
//            }
//        }
//
//        int sum = 0;
//
//        for (int i = len; i >= 0; i--) {
//            sum += count[i];
//
//            if (sum >= i) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
}
