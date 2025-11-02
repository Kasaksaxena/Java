
public class Leetcode344 {
    

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // move pointers
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        reverseString(s);

        System.out.print("Reversed String: ");
        for (char c : s) {
            System.out.print(c);
        }
    }
}
