import java.util.ArrayList;
import java.util.List;

/**
 * Main class to run the Dice Throw problem.
 * You can run this file directly in VS Code.
 */
public class DiceProblem {

    public static void main(String[] args) {
        int targetSum = 4;
        
        System.out.println("--- All Combinations (Printing) ---");
        // Start with an empty processed string "" and the full target.
        diceCombinations("", targetSum);

        System.out.println("\n--- All Combinations (Returning a List) ---");
        List<String> combinations = diceCombinationsList("", targetSum);
        System.out.println(combinations);
    }

    /**
     * This version simply PRINTS all combinations.
     * @param p       The "processed" string of rolls (e.g., "11")
     * @param target  The remaining sum we need to achieve
     */
    public static void diceCombinations(String p, int target) {
        
        // 1. BASE CASE
        // If target is 0, we've hit the exact sum.
        // The 'p' string is a valid combination, so print it.
        if (target == 0) {
            System.out.println(p);
            return;
        }

        // 2. RECURSIVE STEP
        // Loop through all possible die rolls (1 to 6).
        for (int i = 1; i <= 6; i++) {
            
            // We only make a recursive call IF our roll 'i'
            // is not bigger than the target we're trying to hit.
            if (i <= target) {
                // The new processed string is p + i (e.g., "" + 1 -> "1")
                // The new target is target - i (e.g., 4 - 1 -> 3)
                diceCombinations(p + i, target - i);
            }
        }
    }


    /**
     * This version RETURNS an ArrayList of all combinations.
     * (This is the pattern Kunal copy-pastes in the video)
     */
    public static List<String> diceCombinationsList(String p, int target) {
        
        // 1. BASE CASE
        if (target == 0) {
            // We found a valid combination.
            // Create a new list, add our 'p' to it, and return it.
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        // 2. RECURSIVE STEP
        // This list will hold all answers found *below* this call.
        ArrayList<String> allCombinations = new ArrayList<>();

        // Loop through all possible die rolls (1 to 6).
        for (int i = 1; i <= 6; i++) {
            
            if (i <= target) {
                // Make the recursive call. This call will return a list
                // of all solutions it found (e.g., ["11", "2"])
                List<String> resultsFromBelow = diceCombinationsList(p + i, target - i);
                
                // Add all those solutions to our current list.
                allCombinations.addAll(resultsFromBelow);
            }
        }

        // Return the complete list of answers found from this level.
        return allCombinations;
    }
} 
