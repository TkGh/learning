package leetCode1;

public class One_bitNTwo_bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }

        if (bits[bits.length - 2] == 0) {
            return true;
        }

        int i = bits.length - 2;
        while (i >= 1) {
            if (bits[i - 1] == 1) {
                i--;
            } else {
                break;
            }
        }

        return (bits.length - 1 - i) % 2 == 0 ? true : false;
    }

    public static void main(String[] args) {
        int[] bits = {0, 1, 0};
        if (new One_bitNTwo_bitCharacters().isOneBitCharacter(bits)) {
            System.out.println("T");
        }
    }
}
