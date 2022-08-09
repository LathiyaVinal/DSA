// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
  
  
  class Solution {

    public int maxProfit(int[] prices) {
        int buyCost = prices[0];

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyCost > prices[i]) {
                buyCost = prices[i];
            } else if (buyCost < prices[i]) {
                maxProfit = Math.max(maxProfit, (prices[i] - buyCost));
            }
        }
        return maxProfit;
    }
}
