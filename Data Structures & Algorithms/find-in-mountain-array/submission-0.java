/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakindex = getpeak(mountainArr);
        int peak = mountainArr.get(peakindex);
        if (target > peak)
            return -1;

        int left = bsearch(0, peakindex, mountainArr, target, true);
        if (left != -1)
            return left;
        int right = bsearch(peakindex + 1, mountainArr.length() - 1, mountainArr, target, false);
        if (right != -1)
            return right;
        return -1;

    }

    public int getpeak(MountainArray mr) {
        int length = mr.length();
        int l = 0;
        int r = length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            int mnext = mr.get(mid + 1);
            int mmid = mr.get(mid);
            if (mmid <= mnext)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public int bsearch(int start, int end, MountainArray mr, int target, Boolean flag) {
        int l = start;
        int r = end;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int mmid = mr.get(mid);
            if (mmid == target) {
                return mid;
            } else if (mmid < target) {
                if (flag)
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (flag)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;

    }
}