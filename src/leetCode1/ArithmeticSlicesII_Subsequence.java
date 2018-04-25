package leetCode1;

import java.util.*;


public class ArithmeticSlicesII_Subsequence {
    public int numberOfArithmeticSlices(int[] A) {
        MyMap<LstNode> map = new MyMap(A.length);
        for (int num : A) {
            LstNode head = new LstNode(-1, 0, null);
            head.next = head;
            map.put(num, head);
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int Ai = A[i];
            LstNode node = map.get(Ai).next;
            for (int j = i - 1; j >= 0; j--) {
                int count;
                if (node.index == j) {
                    count = node.count + 1;
                    sum += node.count;
                    node = node.next;
                } else {
                    count = 1;
                }
                long nextNumLong = 2L * Ai - A[j];
                if (nextNumLong > Integer.MAX_VALUE || nextNumLong < Integer.MIN_VALUE) {
                    continue;
                }
                int nextNum = (int) nextNumLong;
                LstNode head = map.get(nextNum);
                if (head != null) {
                    LstNode next = head.next;
                    if (next.index == i) {
                        next.count += count;
                    } else {
                        head.next = new LstNode(i, count, next);
                    }
                }
            }
        }
        return sum;
    }
}

final class LstNode {
    LstNode next;
    final int index;
    int count;

    LstNode(int index, int count, LstNode next) {
        this.index = index;
        this.count = count;
        this.next = next;
    }
}

final class MyMap<T> {

    static class MapNode<T> {
        final int key;
        final MapNode next;
        T val;

        MapNode(int key, T val, MapNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private final MapNode<T>[] nodes;

    private final int mask;

    MyMap(int capacity) {
        capacity = Integer.highestOneBit(Integer.max(1, capacity - 1)) << 1;
        this.mask = capacity - 1;
        this.nodes = new MapNode[capacity];
    }

    void put(int key, T val) {
        int hash = getHash(key);
        for (MapNode<T> node = nodes[hash]; node != null; node = node.next) {
            if (node.key == key) {
                node.val = val;
            }
        }
        nodes[hash] = new MapNode(key, val, nodes[hash]);
    }

    T get(int key) {
        int hash = getHash(key);
        for (MapNode<T> node = nodes[hash]; node != null; node = node.next) {
            if (node.key == key) {
                return node.val;
            }
        }
        return null;
    }

    private int getHash(int key) {
        return key & mask;
    }


    public static void main(String[] args) {
        int[] test = {1, 1, 2, 3};
        System.out.println(new ArithmeticSlicesII_Subsequence().numberOfArithmeticSlices(test));
    }
}

/**
 * This answer is bad performance, try to use linkedList promote performance
 * <p>
 * The answer for indexes in some rules: The sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic
 * and the {P0,P1...Pk}is arithmetic
 */
// class Solution {
//    public int numberOfArithmeticSlices(int[] A) {
//        if (A.length < 3) {
//            return 0;
//        }
//
//        int cnt = 0;
//
//        HashMap<Integer, Integer>[] cache = new HashMap[A.length];
//        for (int i = 0; i < A.length; i++) {
//            cache[i] = new HashMap<>();
//            for (int j = 0; j < i; j++) {
//                double gap = (double) A[i] - A[j];
//                if (gap > Integer.MAX_VALUE) {
//                    continue;
//                } else if (gap < Integer.MIN_VALUE) {
//                    continue;
//                } else {
//                    int cntI = cache[j].getOrDefault((int) gap, 0);
//                    cache[i].put((int) gap, cache[i].getOrDefault((int) gap, 0) + cntI + 1);
//                    cnt += cntI;
//                }
//            }
//        }
//
//        return cnt;
//    }
//}

/**
 * The answer for indexes in some rules: The sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic
 * and the {P0,P1...Pk}is arithmetic
 */
//class Solution{
//    public int numberOfArithmeticSlices(int[] A) {
//        if (A.length < 3) {
//            return 0;
//        }
//
//        int[][] cache = new int[A.length][(A.length - 1) / 2 + 1];
//
//        int cnt = 0;
//
//        for (int k = 1; k <= (A.length - 1) / 2; k++) {
//            if (A[k] - A[0] == A[k * 2] - A[k]) {
//                cache[2 * k][k] = 1;
//            }
//            cnt += cache[2 * k][k];
//        }
//
//        for (int i = 3; i < A.length; i++) {
//            int k = 1;
//            for (; k <= i / 2; k++) {
//                int j = i - k;
//                while (A[i] - A[j] == A[j] - A[j - k]) {
//                    cache[i][k] = cache[i - k][k] + 1;
//                }
//                if (i != 2 * k) {
//                    cnt += cache[i][k];
//                }
//            }
//        }
//
//        return cnt;
//    }
//}
