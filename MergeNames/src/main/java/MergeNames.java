import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    public static String[] uniqueNames(String[] names1, String[] names2) {

        ArrayList<String> uniqueNames = new ArrayList<>();

        for (int i = 0; i < names1.length; i++) {
            if (!uniqueNames.contains(names1[i])) {
                uniqueNames.add(names1[i]);
            }
        }

        for (int i = 0; i < names2.length; i++) {
            if (!uniqueNames.contains(names2[i])) {
                uniqueNames.add(names2[i]);
            }
        }

        String[] merged = new String[uniqueNames.size()];

        for (int i = 0; i < uniqueNames.size(); i++) {
            merged[i] = uniqueNames.get(i);
        }
        return merged;
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
