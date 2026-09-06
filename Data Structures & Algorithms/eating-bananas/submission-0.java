class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        int l = 1;
        int res = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(piles, mid) > h)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    public long check(int[] arr, int speed) {
        long hrs = 0;
        for (int num : arr) {
            if (num % speed != 0)
                hrs += (num / speed) + 1;
            else
                hrs += (num / speed);
        }
        return hrs;
    }
}
