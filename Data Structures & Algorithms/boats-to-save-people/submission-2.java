class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int boat= 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        if(i==j) return ++boat;
        while (i < j) {
            if (nums[j] == limit ||(nums[i] + nums[j]) > limit) {
                boat++;
                j--;
            } else {
                boat++;
                i++;
                j--;
            }
            
        }
        if(i==j)boat++;
        return boat;
    }
}