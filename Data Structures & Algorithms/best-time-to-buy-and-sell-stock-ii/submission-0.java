class Solution {
    public int maxProfit(int[] prices) {

    int profit=0;
    int j=1;
    for(int i=0;i<prices.length-1 && j<prices.length;i++){
    if(prices[j]>prices[i]){
        profit+=prices[j]-prices[i];
    }
    j++;

    }
    return profit;
        
    }
}