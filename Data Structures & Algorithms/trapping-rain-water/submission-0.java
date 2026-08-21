class Solution {
    public int trap(int[] height) {
        return process(height);
    }
        public static int process(int[] nums) {

        int res = 0;
        int n = nums.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i <= j && j <= k && k < n) {

            if (j == k) {
                i = k;

                int x = ++k;

                while (x < n) {
                    if (nums[k] <= nums[x])
                        k = x;

                    x++;
                }

                j++;
            }
            else if (nums[i] > nums[j] && nums[j] < nums[k]) {
                res += Math.min(nums[i], nums[k]) - nums[j];
                j++;
            }
            else {
                i = j;
                j++;
            }
        }

        return res;
    }
}
