public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        //  Sample LeetCode-style input
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Call the method and print the result
        int profit = maxProfit(prices);
        System.out.println("Maximum Profit: " + profit);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; //  Update if lower buy price is found
            } else {
                int profit = price - minPrice; //  Try selling today
                maxProfit = Math.max(maxProfit, profit); //  Keep best profit
            }
        }

        return maxProfit;
    }
}
