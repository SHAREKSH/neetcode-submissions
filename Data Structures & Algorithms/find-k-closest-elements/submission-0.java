class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return check(arr, x, k);
    }
    public static ArrayList<Integer> check(int[] arr, int x, int k) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        if (k == n) {
            for (int num : arr) {
                res.add(num);
            }
            return res;
        }

        int i = 0;
        int j = k;

        while (j < n && arr[j] - x < x - arr[i]) {
            i++;
            j++;
        }

        for (int s = i; s < j; s++) {
            res.add(arr[s]);
        }

        return res;
    }
}