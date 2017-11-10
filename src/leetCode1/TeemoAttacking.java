package leetCode1;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) {
            return 0;
        }

        int total = 0;
        int last = timeSeries[0];
        for (int time : timeSeries) {
            if (time < last + duration) {
                total += time - last;
            } else {
                total += duration;
            }
            last = time;
        }

        return total + duration;
    }

    public static void main(String[] args) {
        int[] t = {1, 2};
        System.out.println(new TeemoAttacking().findPoisonedDuration(t, 2));
    }
}
