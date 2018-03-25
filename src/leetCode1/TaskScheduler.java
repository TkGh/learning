package leetCode1;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 1) return 1;

        int[] cnt = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            cnt[tasks[i] - 'A']++;
        }

        Arrays.sort(cnt);

        int max = cnt[cnt.length - 1];
        int length = (cnt[cnt.length - 1] - 1) * (n + 1);
        for (int i = cnt.length - 1; i >= 0; i--) {
            if (cnt[i] != max) break;
            length++;
        }

        return length >= tasks.length ? length : tasks.length;
    }

    public static void main(String[] args) {
        char[] test = {'A', 'A', 'B', 'B', 'A', 'B','C'};
        System.out.println(new TaskScheduler().leastInterval(test, 2));
    }
}
