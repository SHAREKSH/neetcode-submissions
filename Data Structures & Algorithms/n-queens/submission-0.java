class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        List<List<String>> op = new ArrayList<>();

        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> Rdiagonals = new HashSet<>();
        HashSet<Integer> ldiagonals = new HashSet<>();

        check(grid, 0, 0, 0, row, col, Rdiagonals, ldiagonals, n, op);

        return op;
    }

    public void check(char[][] grid, int queen, int c, int r, HashSet<Integer> row,
        HashSet<Integer> col, HashSet<Integer> Rdiagonals, HashSet<Integer> ldiagonals, int n,
        List<List<String>> op) {
        if (queen == n) {
            List<String> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                ans.add(new String(grid[i]));
            }

            op.add(ans);
            return;
        }

        if (r >= n || c >= n) {
            return;
        }

        for (int j = 0; j < n; j++) {
            if (row.contains(r) || col.contains(j) || Rdiagonals.contains(j - r)
                || ldiagonals.contains(j + r)) {
                continue;
            }

            grid[r][j] = 'Q';

            row.add(r);
            col.add(j);
            Rdiagonals.add(j - r);
            ldiagonals.add(j + r);

            check(grid, queen + 1, j, r + 1, row, col, Rdiagonals, ldiagonals, n, op);

            grid[r][j] = '.';

            row.remove(r);
            col.remove(j);
            Rdiagonals.remove(j - r);
            ldiagonals.remove(j + r);
        }
    }
}