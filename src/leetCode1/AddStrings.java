package leetCode1;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1 == "" || num1.equals("0")) {
            return num2;
        }

        if (num2 == null || num2 == "" || num2.equals("0")) {
            return num1;
        }

        StringBuffer sb = new StringBuffer();
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();

        int carry = 0;
        int index = 0;
        int size1 = nums1.length;
        int size2 = nums2.length;

        while (index < size1 && index < size2) {
            int n1 = nums1[size1 - 1 - index] - '0';
            int n2 = nums2[size2 - 1 - index] - '0';
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index++;
        }

        //num1 larger than num2
        while (index < size1) {
            int sum = nums1[size1 - 1 - index] - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index++;
        }

        //num2 larger than num1
        while (index < size2) {
            int sum = nums2[size2 - 1 - index] - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            index++;
        }

        //has carry
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("185", "166"));
    }
}
