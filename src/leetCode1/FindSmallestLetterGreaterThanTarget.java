package leetCode1;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length;
        int mid = start + (end - start) / 2;
        while (start < end) {
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = start + (end - start) / 2;
        }

        return letters[start % letters.length];
    }

}
