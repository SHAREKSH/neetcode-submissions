

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Initialize buckets (index represents frequency)
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        // 3. Group numbers by their frequencies
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            bucket.get(frequency).add(key);
        }

        // 4. Gather the top k elements directly into the result array
        int[] result = new int[k];
        int index = 0;

        // Iterate backwards from highest frequency bucket down to 0
        for (int i = nums.length; i >= 0; i--) {
            for (int num : bucket.get(i)) {
                result[index++] = num;
                // Once we have filled k elements, return immediately
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
