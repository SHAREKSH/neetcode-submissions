class Solution {
    public int firstMissingPositive(int[] nums) {
       int [] arr=nums;
        
    int length = arr.length - 1;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                res = 1;

            if (arr[i] <= 0) {
                arr[i] = 1;
            }
        }

        if (res == 0)
            return 1;

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;

            if (index > length)
                continue;

            if (arr[index] > 0)
                arr[index] = -1 * arr[index];
        }

        res = length+2;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return res;

}
}