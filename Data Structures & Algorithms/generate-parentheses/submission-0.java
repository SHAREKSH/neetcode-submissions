class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> op = new ArrayList<>();
        find(op, n, n, "");
        return op;
    }

    public static void find(List<String> op, int o, int c, String ip) {
        if (o == 0 && c == 0) {
            op.add(ip);
            return;
        }

        if (o > 0) {
            find(op, o - 1, c, ip + "(");
        }

        if (o < c && c > 0) {
            find(op, o, c - 1, ip + ")");
        }
    }
}