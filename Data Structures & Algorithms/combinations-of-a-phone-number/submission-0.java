class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> op = new ArrayList<>();

        if (digits.length() == 0) {
            return op;
        }

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        recurse(op, "", digits, 0, map);

        return op;
    }

    public void recurse(List<String> op, String pr, String digits, int i, String[] map) {
        if (i == digits.length()) {
            op.add(pr);
            return;
        }

        String s = map[digits.charAt(i) - '0'];

        for (int j = 0; j < s.length(); j++) {
            recurse(op, pr + s.charAt(j), digits, i + 1, map);
        }
    }
}
