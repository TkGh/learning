package leetCode1;

import java.util.*;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> rs = new ArrayList<>();
//        int min = newInterval.start;
//        int max = newInterval.end;
//        boolean inserted = false;
//
//        for (Interval interval : intervals) {
//            int curStart = interval.start;
//            int curEnd = interval.end;
//            if (curEnd < min) {
//                rs.add(interval);
//            } else if (curStart > max) {
//                if (!inserted) {
//                    rs.add(new Interval(min, max));
//                }
//                rs.add(interval);
//            } else {
//                min = Math.min(min, curStart);
//                max = Math.max(max, curEnd);
//            }
//        }
//        if (!inserted) {
//            rs.add(new Interval(min, max));
//        }
//        return rs;


        if (intervals == null || intervals.size() == 0) {
            List<Interval> rs = new ArrayList<>();
            rs.add(newInterval);
            return rs;
        }

        int step = 1;               //Check the current step: 1:insert newInterval, 2:merge intervals, 3:return.
        if (newInterval.start < intervals.get(0).start) {
            intervals.add(0, newInterval);
            step++;
        }

        int index = 1;
        while (index < intervals.size()) {
            if (step == 1) {
                if (newInterval.start < intervals.get(index).start) {
                    intervals.add(index, newInterval);
                    step++;
                } else {
                    index++;
                }
            } else if (step == 2) {
                if (intervals.get(index - 1).end >= intervals.get(index).start) {
                    if (intervals.get(index - 1).end >= intervals.get(index).end) {
                        intervals.remove(index);
                    } else {
                        intervals.get(index - 1).end = intervals.get(index).end;
                        intervals.remove(index);
                    }
                } else {
                    index++;
                }
            }
        }

        if (step == 1) {
            intervals.add(newInterval);
            if (intervals.get(intervals.size() - 2).end >= intervals.get(intervals.size() - 1).start) {
                if (intervals.get(intervals.size() - 2).end >= intervals.get(intervals.size() - 1).end) {
                    intervals.remove(intervals.size() - 1);
                } else {
                    intervals.get(intervals.size() - 2).end = intervals.get(intervals.size() - 1).end;
                    intervals.remove(intervals.size() - 1);
                }
            }
        }

        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> test = new ArrayList<>();
        Interval a1 = new Interval(0, 5);
        Interval a2 = new Interval(9, 12);
//        Interval a3 = new Interval(6, 7);
//        Interval a4 = new Interval(8, 10);
//        Interval a5 = new Interval(12, 16);
        test.add(a1);
        test.add(a2);
//        test.add(a3);
//        test.add(a4);
//        test.add(a5);

        InsertInterval t = new InsertInterval();
        t.insert(test, new Interval(7, 16));
        System.out.println();
    }
}
