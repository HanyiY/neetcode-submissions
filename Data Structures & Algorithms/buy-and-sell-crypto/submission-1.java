class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int historyMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++){
            historyMin = Math.min(historyMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - historyMin);
        }
        return maxProfit;
    }
}
