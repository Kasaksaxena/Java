import java.util.*;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];  // for 'a' to 'z'

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;   // count from s
            freq[t.charAt(i) - 'a']--;   // remove from t
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        if (isAnagram(s, t)) {
            System.out.println("✅ '" + t + "' is an anagram of '" + s + "'");
        } else {
            System.out.println("❌ '" + t + "' is NOT an anagram of '" + s + "'");
        }
    }
}