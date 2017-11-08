package leetCode1;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        int i = n & 1;
        while (i == 0) {
            n >>>= 1;
            i = n & 1;
        }
        n >>>= 1;

        i = n | 0;
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        if (new PowerOfTwo().isPowerOfTwo(1)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
