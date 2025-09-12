import java.util.Arrays;

public class ShipwithinDays {

    public static int shipWithinDays(int[] weights, int days) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int left = 0;
        long right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        // Binary search for minimum capacity
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canShipInDays(weights, mid, days)) {
                right = mid;
            } else {
                left = (int) (mid + 1);
            }
        }
        return left;
    }

    private static boolean canShipInDays(int[] weights, long capacity, int D) {
        int daysNeeded = 1;
        long currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += w;
            if (daysNeeded > D) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] weights1 = {1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        int result1 = shipWithinDays(weights1, days1);
        System.out.println("Output for weights1, days1 = " + result1);
        // Expected: 15

        // Test case 2
        int[] weights2 = {10,50,100,100,50,100,100,100};
        int days2 = 5;
        int result2 = shipWithinDays(weights2, days2);
        System.out.println("Output for weights2, days2 = " + result2);
        // Expected: 160
    }
}
