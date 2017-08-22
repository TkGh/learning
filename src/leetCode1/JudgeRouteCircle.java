package leetCode1;

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        char[] movesArray = moves.toCharArray();
        int size = movesArray.length;

        //odd moves can't be a circle.
        if (size % 2 == 1) {
            return false;
        }

        //create two Integers represent the longitude and latitude of ROBOT move, and initialize it.
        int longitude = 0;
        int latitude = 0;


        for (int i = 0; i < size; i++) {
            if (movesArray[i] == 'U') {
                longitude += 1;
            } else if (movesArray[i] == 'D') {
                longitude -= 1;
            } else if (movesArray[i] == 'L') {
                latitude += 1;
            } else {
                latitude -= 1;
            }
        }

        return longitude == 0 && latitude == 0;
    }

    public static void main(String[] args) {
        String test = "UD";
        String test2 = "RR";
        JudgeRouteCircle demo = new JudgeRouteCircle();
        if (demo.judgeCircle(test)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
