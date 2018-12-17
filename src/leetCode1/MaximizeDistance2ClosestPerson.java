package leetCode1;

public class MaximizeDistance2ClosestPerson {
    public int maxDistToClosest(int[] seats) {
        if (seats.length == 1) return 0;

        int res = 0;

        int begin = 0;
        int end = seats.length - 1;
        while (seats[begin] != 1) {
            begin++;
        }
        while (seats[end] != 1) {
            end--;
        }
        res = begin > seats.length - 1 - end ? begin : seats.length - 1 - end;

        int cnt = 0;
        for (int i = begin + 1; i <= end; i++) {
            if (seats[i] == 1) {
                res = Math.max((cnt + 1) / 2, res);
                cnt = 0;
            } else {
                cnt++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 0, 1};
        System.out.print(new MaximizeDistance2ClosestPerson().maxDistToClosest(test));
    }
}
