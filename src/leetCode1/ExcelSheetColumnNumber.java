package leetCode1;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s == "") {
            return 0;
        }

        int num = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            num = num * 26 + c - 'A' + 1;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
    }
}
