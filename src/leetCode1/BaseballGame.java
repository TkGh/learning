package leetCode1;

import java.util.*;

public class BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }

        Stack<Integer> points = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                if (points.size() >= 2) {
                    int lastS = points.pop();
                    int currS = lastS + points.peek();
                    points.push(lastS);
                    points.push(currS);
                }
            } else if (op.equals("D")) {
                if (points.size() >= 1) {
                    int currS = points.peek() * 2;
                    points.push(currS);
                }
            } else if (op.equals("C")) {
                if (points.size() >= 1) {
                    points.pop();
                }
            } else {
                points.push(new Integer(op));
            }
        }

        int point = 0;
        while (!points.empty()) {
            point += points.pop();
        }

        return point;
    }

    public static void main(String[] args) {
        BaseballGame demo = new BaseballGame();
        String[] test = {"5","-2","4","C","D","9","+","+"};
        System.out.println(demo.calPoints(test));
    }
}
