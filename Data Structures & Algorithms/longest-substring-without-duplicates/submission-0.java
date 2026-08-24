class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

    int n = s.length();
    int i = 0;
    int j = 0;
    int res = 0;
    if (n==1) return 1;

    while (j < n) {
        if (!set.add(s.charAt(j))) {
            res = Math.max(res, j - i);
            set.remove(s.charAt(i));
            i++;
        } else {
            
            res = Math.max(res, j - i+1);
            j++;
        }
    }

    return res;
    }
}