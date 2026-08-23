class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int res = 0;

        while (j < prices.length) {
            int currentProfit = prices[j] - prices[i];
            if (currentProfit > 0) {
                res = Math.max(res, currentProfit);
                j++;
            } else {
                i = j;
                j++;
            }
        }
        return res;
    }
}
