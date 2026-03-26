import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        // Step 0: quick check
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: count characters of s
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: reduce using t
        for (char c : t.toCharArray()) {

            // if char not present → not anagram
            if (!map.containsKey(c)) return false;

            // decrease frequency
            map.put(c, map.get(c) - 1);

            // if frequency becomes 0 → remove it
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        // Step 3: if empty → valid anagram
        return map.isEmpty();
    }

    // test
    public static void main(String[] args) {
        String s = "aab";
        String t = "aba";

        System.out.println(isAnagram(s, t)); // true
    }
}