package leetCode1;

import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        //check valid input length:
        int length = intervals.size();
        if (length <= 1) {
            return intervals;
        }

        //Sort by ascending starting point using Quick sort:
        sort(intervals, 0, length - 1);


        //remove overlapped intervals:
        int index = 1;
        while (index < intervals.size()) {
            if (intervals.get(index - 1).end >= intervals.get(index).start) {       //overlapping intervals
                if (intervals.get(index - 1).end >= intervals.get(index).end) {     //complete overlapping interval, delete it
                    intervals.remove(index);
                } else {                                                            //Not complete overlapping interval, change
                    intervals.get(index - 1).end = intervals.get(index).end;        //the previous interval's end, and delete the
                    intervals.remove(index);                                        //overlapping one.
                }
            } else {                                                                //disjoint intervals, check next pair.
                index++;
            }
        }
        return intervals;
    }


    //Quick sort:
    private void sort(List<Interval> intervals, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(intervals, low, high);
        sort(intervals, low, j - 1);
        sort(intervals, j + 1, high);

    }

    private int partition(List<Interval> intervals, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = intervals.get(low).start;

        while (true) {
            while (less(intervals.get(++i).start, v)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, intervals.get(--j).start)) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(intervals, i, j);
        }
        exch(intervals, low, j);
        return j;
    }

    private void exch(List<Interval> intervalz, int index1, int index2) {
        Interval tem = intervalz.get(index1);
        intervalz.set(index1, intervalz.get(index2));
        intervalz.set(index2, tem);
    }

    private boolean less(int var1, int var2) {
        return var1 - var2 < 0 ? true : false;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(16, 26);
        Interval i3 = new Interval(2, 6);

        List<Interval> test = new ArrayList<>();
        test.add(i1);
        test.add(i2);
        test.add(i3);

        MergeIntervals m = new MergeIntervals();
        m.merge(test);
    }
}