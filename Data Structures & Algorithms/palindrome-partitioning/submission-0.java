class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> op = new ArrayList<>();
        List<String> pr = new ArrayList<>();

        find(op, pr, s, 0);

        return op;
    }

    public void find(List<List<String>> op,
                     List<String> pr,
                     String s,
                     int i) {

        if (i == s.length()) {
            op.add(new ArrayList<>(pr));
            return;
        }

        for (int j = i; j < s.length(); j++) {

            String temp = s.substring(i, j + 1);

            if (!isPalindrom(temp))
                continue;

            pr.add(temp);

            find(op, pr, s, j + 1);

            pr.remove(pr.size() - 1);
        }
    }

    public boolean isPalindrom(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}