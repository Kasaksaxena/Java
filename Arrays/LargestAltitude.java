public class LargestAltitude {

    public static int largestAltitude(int[] gain) {

        int n = gain.length;

        int[] prefix = new int[n + 1];   // prefix[0] = 0
        int highest = 0;                 // Starting altitude

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + gain[i];
            highest = Math.max(highest, prefix[i + 1]);
        }

        return highest;
    }

    public static void main(String[] args) {

        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain1)); // 1

        int[] gain2 = {-4, -3, -2};
        System.out.println(largestAltitude(gain2)); // 0

        int[] gain3 = {4, -2, 3, -1};
        System.out.println(largestAltitude(gain3)); // 5

        int[] gain4 = {1, 2, 3};
        System.out.println(largestAltitude(gain4)); // 6
    }
}