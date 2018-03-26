package leetCode1;

import java.util.ArrayList;
import java.util.List;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (num.length() == k) return "0";

        //remove k digits:
        StringBuffer sb = new StringBuffer();
        int begin = 0;
        int end = 0;
        while (k > 0 && end < num.length()) {
            for (; end < num.length(); end++) {
                if (num.charAt(end) == '0') break;
            }
            if (end - begin == k) {          //exact k digits can be remove
                sb.append(num.substring(end));
                break;
            } else if (end - begin > k) {    //more than k digits can be remove
                List<Character> tmp = new ArrayList<>();
                for (int i = begin; i < end; i++) {
                    tmp.add(num.charAt(i));
                }
                int i = 0;
                while (i < tmp.size() - 1 && k > 0) {
                    if (tmp.get(i) > tmp.get(i + 1)) {
                        tmp.remove(i);
                        i = i == 0 ? 0 : i - 1;
                        k--;
                    } else {
                        i++;
                    }
                }
                for (i = 0; i < tmp.size() - k; i++) {
                    sb.append(tmp.get(i));
                }

                sb.append(num.substring(end));
                break;
            } else {                                                  //less than k digits can be remove
                k -= end - begin;
                end = end + 1;
                begin = end;
            }
        }

        //check:
        if (sb.length() == 0) return "0";

        //remove the leading zero:
        begin = 0;
        for (; begin < sb.length(); begin++) {
            if (sb.charAt(begin) != '0') break;
        }

        return begin == sb.length() ? "0" : sb.substring(begin);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("4874161", 6));
    }
}
