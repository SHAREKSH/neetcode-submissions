class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int k) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> pr = new ArrayList<>();

        Arrays.sort(arr);
        find(arr, op, pr, 0, k, 0);

        return op;
    }

    public void find(int arr[], List<List<Integer>> op, List<Integer> pr,
                     int j, int k, int sum) {

        if (sum == k) {
            op.add(new ArrayList<>(pr));
            return;
        } else if (sum > k) {
            return;
        }

        for (int i = j; i < arr.length; i++) {
            if (i > j && arr[i] == arr[i - 1])
                continue;

            pr.add(arr[i]);
            find(arr, op, pr, i + 1, k, sum + arr[i]);
            pr.remove(pr.size() - 1);
        }
    }
}