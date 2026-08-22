class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int boat= 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        if(i==j) return ++boat;
        while (i < j) {
            if (nums[j] == limit || limit - (nums[i] + nums[j]) < 0) {
                boat++;
                j--;
            } else if (nums[i] + nums[j] == limit) {
                boat++;
                i++;
                j--;
            } else if (limit - (nums[i] + nums[j]) < nums[i]) {
                boat++;
                i++;
                j--;
            } else {
                int req = limit - (nums[i] + nums[j]);
                int k = i + 1;
                int sum = 0;
                while (k < j) {
                    sum += nums[k];
                    if (sum  >= req) {
                        break;
                    }
                    k++;
                }
                boat++;
                j--;
                i = k;
            }
            if(i==j)boat++;
        }
        return boat;
    }
}