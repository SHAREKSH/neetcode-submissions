class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return find(nums,k);
        
    }
    public static int[] find(int[] arr, int k) {
    int[] res = new int[arr.length - k + 1];

    if (k == 1)
        return arr;

    Deque<Integer> dq = new ArrayDeque<>();

    int i = 0;
    int j = 0;
    int n = arr.length;
    int counter = 0;

    while (j < n) {
        insert(dq, j, arr);

        if (j - i + 1 == k) {
            res[counter] = arr[dq.peekFirst()];

            // CHANGED: peekLast() → peekFirst()
            if (dq.peekFirst() == i)
                dq.pollFirst();

            i++;
            counter++;
        }

        j++;
    }

    return res;
}

public static void insert(Deque<Integer> dq, int element, int[] arr) {
    while (!dq.isEmpty()) {
        if (arr[dq.peekLast()] >= arr[element]) {
            dq.offerLast(element);
            break;
        } else {
            dq.pollLast();
        }
    }

    if (dq.isEmpty())
        dq.offerLast(element);
}
}
