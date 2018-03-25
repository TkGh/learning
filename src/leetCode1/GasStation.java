package leetCode1;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) return -1;

        int[] remains = new int[gas.length];
        for (int i = 0; i < remains.length; i++) {
            remains[i] = gas[i] - cost[i];
        }
        int remain = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
        }
        if (remain < 0) return -1;
        int i = 0;
        for (; i < gas.length; i++) {
            if (gas[i] - cost[i] > 0) break;
        }
        int j = i;
        remain = gas[i % gas.length]-cost[i%gas.length];
        while (j - i < remains.length) {
            if (remain >= 0) {
                j++;
                remain += remains[j % remains.length];
            } else {
                remain -= remains[i % remains.length];
                i++;
            }
            if (i > j) {
                j = i;
                remain = remains[i % remains.length];
            }
        }

        return i % remains.length;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2};
        int[] cost = {2, 1};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
