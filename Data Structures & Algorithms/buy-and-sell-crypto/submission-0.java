class Solution {
    public int maxProfit(int[] prices) {

        int i=0;
        int j=1;
        int res=0;

        while(j<prices.length){
            if(prices[j]-prices[i]>0){
                res=Math.max(res,prices[j]-prices[i]);
                j++;
            }else{
            i=j;
            j++;
            }
        }
        return res;
        
    }
}
