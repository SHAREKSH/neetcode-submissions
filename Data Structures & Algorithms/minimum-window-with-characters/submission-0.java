class Solution {
    public String minWindow(String s, String t) {
        return check(s, t);
    }public static String check(String s, String t) {
    String res = "";

    int vi = 0;
    int vj = s.length();

    int n = s.length();
    int m = t.length();

    int[] actual = new int[52];
    int[] calculated = new int[52];

    // Build frequency of t
    for (int x = 0; x < m; x++) {
        int index = getIndex(t.charAt(x));
        actual[index]++;
    }

    int i = 0;
    int j = 0;

    while (j < n) {

        int index = getIndex(s.charAt(j));
        calculated[index]++;

        // Shrink while current window is valid
        while (valid(actual, calculated)) {

            if ((vj - vi + 1) > (j - i + 1)) {
                vj = j;
                vi = i;
            }

            // Remove leftmost character
            index = getIndex(s.charAt(i));
            calculated[index]--;

            i++;
        }

        j++;
    }

    // No valid window found
    if (vj == s.length())
        return "";

    return s.substring(vi, vj + 1);
}

public static boolean valid(int[] a, int[] b) {

    for (int i = 0; i < 52; i++) {

        // Only check characters present in t
        if (a[i] != 0) {

            // Current window must have at least
            // the required number of characters
            if (a[i] > b[i])
                return false;
        }
    }

    return true;
}

public static int getIndex(char c) {

    if (c >= 'A' && c <= 'Z') {
        return c - 'A';
    }

    // lowercase
    return c - 'a' + 26;
}
}
