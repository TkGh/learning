package leetCode1;

public class Dota2Senate {
    //The strategy is every senator will ban the opposite senator nearest behind him
    public String predictPartyVictory(String senate) {

        if (votePerR(senate).toString().equals("D")) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    //Each round we can get a shorter string, when the string length attach 1
    // or radVote != 0 || dirVote != 0 after a round, we get the final answer.
    private StringBuffer votePerR(String senate) {
        StringBuffer sb = new StringBuffer();

        int radVote = 0;
        int dirVote = 0;
        int i = 0;
        while (i < senate.length()) {
            while (i < senate.length() && senate.charAt(i) == 'D') {
                if (radVote != 0) {
                    radVote--;
                } else {
                    dirVote++;
                    sb.append('D');
                }
                i++;
            }
            while (i < senate.length() && senate.charAt(i) == 'R') {
                if (dirVote != 0) {
                    dirVote--;
                } else {
                    radVote++;
                    sb.append('R');
                }
                i++;
            }
        }

        while (dirVote > 0) {
            int index = 0;
            while (index < sb.length()) {
                if (sb.charAt(index) == 'R') {
                    break;
                }
                index++;
            }
            if (index == sb.length()) {
                break;
            }
            sb.delete(index, index + 1);
            dirVote--;
        }

        while (radVote > 0) {
            int index = 0;
            while (index < sb.length()) {
                if (sb.charAt(index) == 'D') {
                    break;
                }
                index++;
            }
            if (index == sb.length()) {
                break;
            }
            sb.delete(index, index + 1);
            radVote--;
        }

        if (radVote != 0) {
            return new StringBuffer("R");
        } else if (dirVote != 0) {
            return new StringBuffer("D");
        } else if (sb.length() == 1) {
            return sb;
        } else {
            return votePerR(sb.toString());
        }
    }

    public static void main(String[] args) {
        String test = "RDDRDD";
        System.out.println(new Dota2Senate().predictPartyVictory(test));
    }
}
