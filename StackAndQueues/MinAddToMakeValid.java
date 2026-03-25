public class MinAddToMakeValid {

    public static int minAddToMakeValid(String s) {

        int open = 0; // unmatched '('
        int add = 0;  // additions needed

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } else {

                if (open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }

        return add + open;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));   // 1
        System.out.println(minAddToMakeValid("((("));   // 3
        System.out.println(minAddToMakeValid("()))((")); // 4
    }
}