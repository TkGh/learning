package leetCode1;

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.equals("")) {
            return b;
        }
        if (b == null || b.equals("")) {
            return a;
        }

        int carry = 0;
        char[] bitA = a.toCharArray();
        char[] bitB = b.toCharArray();

        int indexA = bitA.length - 1;
        int indexB = bitB.length - 1;

        StringBuffer sb = new StringBuffer();

        while (indexA >= 0 || indexB >= 0) {
            int sum = carry;
            if (indexA >= 0) {
                sum += bitA[indexA--] - '0';
            }
            if (indexB >= 0) {
                sum += bitB[indexB--] - '0';
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
