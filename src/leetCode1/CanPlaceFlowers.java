package leetCode1;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n > (flowerbed.length + 1) / 2) {
            return false;
        }

        int[] fakeBed = new int[flowerbed.length + 2];
        fakeBed[0] = 0;
        fakeBed[fakeBed.length - 1] = 0;
        for (int i = 1; i < fakeBed.length - 1; i++) {
            fakeBed[i] = flowerbed[i - 1];
        }

        int index = 0;
        while (index < fakeBed.length) {
            while (index < fakeBed.length && fakeBed[index] == 1) {
                index++;
            }
            int count = 0;
            while (index < fakeBed.length && fakeBed[index] == 0) {
                count++;
                index++;
            }
            n -= (count - 1) / 2;
        }

        return n <= 0;
    }

    public static void main(String[] args) {
        int[] test = {0,0,1,0,0};
        if (new CanPlaceFlowers().canPlaceFlowers(test, 1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
