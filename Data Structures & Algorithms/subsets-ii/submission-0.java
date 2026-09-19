class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            int n = result.size();
            end = n - 1;
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(result.get(j));
                internal.add(nums[i]);
                result.add(internal);

            }
        }
        return result;

    }

}