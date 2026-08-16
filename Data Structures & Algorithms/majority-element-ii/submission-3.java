
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Edge case safety check
        if (nums == null || nums.length == 0) return new ArrayList<>();

        // Step 1: Voting Process (Rectified into a single mutually exclusive chain)
        int var1 = 0, var2 = 0;
        int var1_count = 0, var2_count = 0;
        
        for (int num : nums) {
            if (num == var1 && var1_count > 0) {
                var1_count++;
            } else if (num == var2 && var2_count > 0) {
                var2_count++;
            } else if (var1_count == 0) {
                var1 = num;
                var1_count = 1;
            } else if (var2_count == 0) {
                var2 = num;
                var2_count = 1;
            } else {
                var1_count--;
                var2_count--;
            }
        }

        // Step 2: Verification Process (Rectified to count accurately)
        List<Integer> op = new ArrayList<>();
        int threshold = nums.length / 3;
    
        // Count for candidate 1
        int count1 = 0;
        for (int num : nums) {
            if (var1 == num) {
                count1++;
            }
        }
        if (count1 > threshold) { 
            op.add(var1);
        }

        // Count for candidate 2 (only if it's a completely different number)
        if (var1 != var2) {
            int count2 = 0;
            for (int num : nums) {
                if (var2 == num) {
                    count2++;
                }
            }
            if (count2 > threshold) {
                op.add(var2);
            }
        }

        return op;
    }
}
