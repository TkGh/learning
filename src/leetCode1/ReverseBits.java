package leetCode1;

import java.util.HashMap;

public class ReverseBits {
    private HashMap<Byte, Integer> cache = new HashMap<>();

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) ((n >>> 8 * i) & 0xFF);
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += reverse(bytes[i]);
            if (i < 3) {
                res <<= 8;
            }
        }


        return res;
    }

    private int reverse(Byte b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        }
        int value = 0;
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7) {
                value <<= 1;
            }

        }
        cache.put(b, value);

        return value;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
    }
}

//EZ solution:
class solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31)
                result <<= 1;
        }
        return result;
    }
}