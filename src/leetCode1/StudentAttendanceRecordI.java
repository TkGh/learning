package leetCode1;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
       return !s.matches("\\w*A\\w*A\\w*|\\w*LLL\\w*");
    }

    public static void main(String[] args) {
        String s = "LLPPLA";
        if (new StudentAttendanceRecordI().checkRecord(s)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
