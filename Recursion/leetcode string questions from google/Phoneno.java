import java.util.ArrayList;
import java.util.List;

public class Phoneno {

    public static void main(String[] args) {
        
        // 1. Create an instance of your Solution class
        // You need an object to call its methods.
        Solution sol = new Solution();

        // 2. Define the input digits you want to test
        String digitsToTest = "23";

        // 3. Call the letterCombinations method
        // This runs your recursive logic and gets the final list.
        
        List<String> combinations = sol.letterCombinations(digitsToTest);

        // 4. Print the results to the VS Code terminal
        System.out.println("Input digits: " + digitsToTest);
        System.out.println("Generated combinations:");
        System.out.println(combinations);

        // You can test another case:
        String digitsToTest2 = "7";
        List<String> combinations2 = sol.letterCombinations(digitsToTest2);
        System.out.println("\nInput digits: " + digitsToTest2);
        System.out.println("Generated combinations:");
        System.out.println(combinations2);
    }
}


/**
 * -----------------------------------------------------------------
 * This is your original Solution class.
 * It's kept separate from the main "PhoneNo" class for good organization.
 * The main method above will create an object of this class to use it.
 * -----------------------------------------------------------------
 */
class Solution {

    // 1. The Mapping
    // This is a "lookup table" or map to get letters for a digit.
    // Index 2 maps to "abc", index 3 to "def", etc.
    // We add empty strings at 0 and 1 for easy indexing.
    private final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        
        // 2. The Main Result List
        // This list will store all the final combinations.
        List<String> results = new ArrayList<>();

        // 3. Edge Case
        // If the input is empty, just return the empty list.
        if (digits == null || digits.isEmpty()) {
            return results;
        }

        // 4. The Initial Call
        // We start the recursion.
        // Processed (p) starts as an empty string "".
        // Unprocessed (up) starts as the full digits string.
        solve("", digits, results);

        return results;
    }

    /**
     * The recursive helper function
     * @param p       The "processed" string we are building
     * @param up      The "unprocessed" digits we still need to handle
     * @param results The final list to add answers to
     */
    private void solve(String p, String up, List<String> results) {

        // 5. BASE CASE
        // If 'up' is empty, we have no more digits to process.
        // This means 'p' is a complete combination.
        if (up.isEmpty()) {
            // Add the 'p' we built to the final list.
            results.add(p);
            return; // Stop this recursive path.
        }

        // 6. RECURSIVE STEP

        // Get the first digit from the 'up' string.
        // If up="23", digitChar is '2'
        char digitChar = up.charAt(0); // '2'

        // Convert the char '2' to the int 2.
        // The ASCII value of '2' minus '0' gives the integer 2.
        int digitInt = digitChar - '0'; // 2

        // Get the corresponding letters from our map.
        // letters = MAPPING[2] which is "abc"
        String letters = MAPPING[digitInt];

        // 7. The "Choices" Loop
        // This is the core logic. We must make a new recursive call
        // for *each* possible letter.
        for (int i = 0; i < letters.length(); i++) {
            
            // Get the current choice.
            // 1st loop: choice = 'a'
            // 2nd loop: choice = 'b'
            // 3rd loop: choice = 'c'
            char choice = letters.charAt(i);

            // 8. The Recursive Call
            // We make a new call with the *updated* p and up.
            //
            // If p="", up="23", choice='a':
            //   New p: "" + 'a'  -> "a"
            //   New up: "23".substring(1) -> "3"
            //   Call: solve("a", "3", results)
            //
            // If p="", up="23", choice='b':
            //   New p: "" + 'b'  -> "b"
            //   New up: "23".substring(1) -> "3"
            //   Call: solve("b", "3", results)
            //
            solve(p + choice, up.substring(1), results);
        }
    }
}