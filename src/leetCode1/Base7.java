package leetCode1;

public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();

        //Get the abs number:
        int abs = Math.abs(num);
        while (abs != 0) {
            sb.append(abs % 7);
            abs /= 7;
        }

        //Get the sign:
        if (num < 0) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(-10));
    }
}
