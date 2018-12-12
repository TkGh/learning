package leetCode1;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if (emails.length == 1) return 1;
        Set<String> email = new HashSet<>();

        for (String str : emails) {
            String[] parts = str.split("\\@");
            String[] name = parts[0].split("\\+");
            name[0] = name[0].replaceAll(",", "");
            String target = name[0] + parts[1];
            if (!email.contains(target)) email.add(target);
        }

        return email.size();
    }
}
