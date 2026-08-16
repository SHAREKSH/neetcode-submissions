class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        int[] arr = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            prefix += num;
            arr[i] = prefix;
            i++;
        }
        for (int num : arr) {
            if (num == k) {
                count++;
            }  if (map.containsKey(num - k)){
                count += map.get(num - k);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}