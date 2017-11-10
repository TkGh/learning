package leetCode1;

public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];

        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }

        res[0] = area / width;
        res[1] = width;


        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructTheRectangle().constructRectangle(12));
    }
}
