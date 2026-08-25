class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    int n=nums.length;
    int i=0;
    int j=0;
    int res=n+1;
    int sum=0;

    while(j<n){
    sum+=nums[j];
    while(sum>=target && i<=j){
    res=Math.min(res,j-i+1);
    sum-=nums[i];
    i++;
    }
    j++;
    
    }
    if(res==n+1) res=0;
    return res;
    }

}