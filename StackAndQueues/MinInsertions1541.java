public class MinInsertions1541 {

    public static int minInsertions(String s) {

        int need = 0; // required ')'
        int add = 0;  // insertions

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                need += 2;

                // if need is odd → fix imbalance
                if (need % 2 == 1) {
                    add++;
                    need--; // make it even
                }

            } else {

                need--;

                // too many ')'
                if (need == -1) {
                    add++;
                    need = 1;
                }
            }
        }

        return add + need;
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("(()))")); // 1
        System.out.println(minInsertions("())"));   // 0
        System.out.println(minInsertions("))())(")); // 3
    }
}