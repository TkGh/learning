package leetCode1;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            int pos = (n - 1) % 26 + 'A';
            sb.append((char) pos);
            n = (n - 1) / 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
    }
}
