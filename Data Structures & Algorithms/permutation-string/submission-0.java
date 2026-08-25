class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return check(s1, s2) ;
    }public static boolean check(String s1, String s2) {
    int k = s1.length();

    int[] mask = new int[26];
    int[] pattern = new int[26];

    for (char ch : s1.toCharArray()) {
        int index = ch - 'a';
        pattern[index] += 1;
    }

    String pstring = Arrays.toString(pattern);

    int i = 0;
    int j = 0;

    while (j < s2.length()) {
        int index = s2.charAt(j) - 'a';
        mask[index] += 1;

        if (j - i + 1 == k) {
            String cstring = Arrays.toString(mask);
           

            if (pstring.equals(cstring)) {
                return true;
            } else {
                index = s2.charAt(i) - 'a';
                mask[index] -= 1;
                i++;
            }
        }

        j++;
    }

    return false;
}
}