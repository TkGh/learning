package leetCode1;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        candies[ratings.length - 1] = Math.max(candies[ratings.length - 1], 1);
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }

        int res = 0;
        for (int c : candies) {
            res += c;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 4, 3, 2, 5, 7, 6};
        System.out.print(new Candy().candy(test));
    }
}
