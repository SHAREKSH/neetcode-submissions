class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> processed = new ArrayList<>();

        form(nums, output, processed, 0);

        return output;
    }
    public void form(int[] arr, List<List<Integer>> output, List<Integer> processed, int i) {
        if (i == arr.length) {
            output.add(new ArrayList<>(processed));
            return;
        }

        processed.add(arr[i]);

        form(arr, output, processed, i + 1);

        processed.remove(processed.size() - 1);

        form(arr, output, processed, i + 1);
    }
}
