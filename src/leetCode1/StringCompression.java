package leetCode1;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int start = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count == 1) {
                    chars[++start] = chars[i];
                } else {
                    char[] cntInChar = String.valueOf(count).toCharArray();
                    for (char c : cntInChar) {
                        chars[++start] = c;
                    }
                    chars[++start] = chars[i];
                }
                count = 1;
            }
        }

        if (count != 1) {
            char[] cntInChar = String.valueOf(count).toCharArray();
            for (char c : cntInChar) {
                chars[++start] = c;
            }
        }

        return start + 1;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c','c'};
        System.out.println(new StringCompression().compress(chars));
    }
}
