package leetCode1;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] hp = new int[row][col];

        hp[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]);

        for (int i = row - 2; i >= 0; i--) {
            hp[i][col - 1] = Math.max(hp[i + 1][col - 1] - dungeon[i][col - 1], 1);
        }

        for (int i = col - 2; i >= 0; i--) {
            hp[row - 1][i] = Math.max(hp[row - 1][i + 1] - dungeon[row - 1][i], 1);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int right = Math.max(hp[i][j + 1] - dungeon[i][j], 1);
                int down = Math.max(hp[i + 1][j] - dungeon[i][j], 1);
                hp[i][j] = Math.min(right, down);
            }
        }

        return hp[0][0];
    }

    public static void main(String[] args) {
        int[][] test = {{0, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
        System.out.print(new DungeonGame().calculateMinimumHP(test));
    }
}