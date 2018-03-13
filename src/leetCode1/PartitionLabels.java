package leetCode1;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Letter> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new Letter(-1, -1));
        }

        Letter fake;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            fake = list.get(S.charAt(i) - 'a');
            if (fake.start == -1) {
                fake.start = i;
            }
            if (fake.end < i) {
                fake.end = i;
            }
        }
        Collections.sort(list, new Comparator<Letter>() {
            @Override
            public int compare(Letter o1, Letter o2) {
                return o1.start - o2.start;
            }
        });

        int i = 0;
        for (; i < 26; i++) {
            if (list.get(i).start != -1) break;
        }
        int start = list.get(i).start, end = list.get(i).end;
        int startC = start, endC = end;
        i++;
        for (; i < 26; i++) {
            startC = list.get(i).start;
            endC = list.get(i).end;
            if (startC > end) {
                res.add(end - start + 1);
                start = startC;
                end = endC;
            } else if (endC > end) {
                end = endC;
            }
        }
        res.add(end - start + 1);

        return res;
    }

    class Letter {
        int start;
        int end;

        Letter(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = new PartitionLabels().partitionLabels(s);
        System.out.println("hold on");
    }
}
