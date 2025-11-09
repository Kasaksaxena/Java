// leetcode 46
import java.util.ArrayList;
import java.util.List;

/**
 * This 'Main' class is the entry point for the application.
 * You can run this file directly in VS Code.
 */
public class PermutationsIntegers {
    public static void main(String[] args) {
        // 1. Create an instance of the Solution class
        Solution solution = new Solution();

        // 2. Define the test input
        int[] nums = {1, 2, 3};

        // 3. Call the permute method
        List<List<Integer>> allPermutations = solution.permute(nums);

        // 4. Print the result
        System.out.println("All permutations of [1, 2, 3]:");
        System.out.println(allPermutations);

        // --- You can test with other inputs too ---
        // int[] nums2 = {1, 2};
        // List<List<Integer>> allPermutations2 = solution.permute(nums2);
        // System.out.println("\nAll permutations of [1, 2]:");
        // System.out.println(allPermutations2);
    }
}

/**
 * This is the Solution class you provided.
 * It's designed to solve the LeetCode problem.
 */
class Solution {
    
    // This is our main list that will store all the final permutations.
    List<List<Integer>> finalResults;

    public List<List<Integer>> permute(int[] nums) {
        finalResults = new ArrayList<>();
        
        // Start the recursion.
        // p (processed) is an empty list.
        // up (unprocessed) is the 'nums' array. We use 'index' to track
        // which part of 'nums' is currently unprocessed.
        // index = 0 means the unprocessed part starts at nums[0].
        solve(new ArrayList<>(), nums, 0);
        
        return finalResults;
    }

    /**
     * The recursive helper function.
     * @param p       The "processed" list (the permutation we are building).
     * @param up      The "unprocessed" array (the original 'nums').
     * @param index   The index of the *first* element in the 'up' part.
     */
    private void solve(List<Integer> p, int[] up, int index) {
        
        // --- BASE CASE ---
        // If 'index' reaches the end of 'up', it means 'up' is empty.
        // We have no more numbers to process.
        // 'p' is now a complete permutation, so add it to our final results.
        if (index == up.length) {
            finalResults.add(new ArrayList<>(p)); // Add a *copy* of p
            return;
        }

        // --- RECURSIVE STEP ---

        // 1. Get the character to insert (like 'ch' from the string video)
        // This is the first number from the "unprocessed" part.
        int numToInsert = up[index];

        // 2. Loop through all possible insertion spots in 'p'.
        // We loop from i = 0 to p.size() (inclusive) to get all spots,
        // from the very beginning to the very end.
        for (int i = 0; i <= p.size(); i++) {
            
            // 3. Create the new "processed" list (like 'f + ch + s')
            
            // Create a new list 'newP' that is a copy of 'p'
            List<Integer> newP = new ArrayList<>(p);
            
            // Insert 'numToInsert' at position 'i'.
            // This is the same as: firstPart + ch + secondPart
            newP.add(i, numToInsert);

            // 4. Make the recursive call
            // We pass our 'newP' as the *new* processed list.
            // We pass 'index + 1' to signify that the "unprocessed" part
            // now starts one element later (like 'up.substring(1)').
            solve(newP, up, index + 1);
        }
    }
}