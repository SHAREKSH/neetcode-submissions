class Solution {
    int res=0;
    public int totalNQueens(int n) {
            char[][] grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> Rdiagonals = new HashSet<>();
        HashSet<Integer> ldiagonals = new HashSet<>();

        check(grid, 0, 0, 0, row, col, Rdiagonals, ldiagonals, n);
        return res;
    }
    
    public void check(char[][] grid, int queen, int c, int r, HashSet<Integer> row,
        HashSet<Integer> col, HashSet<Integer> Rdiagonals, HashSet<Integer> ldiagonals, int n) {
        if (queen == n) {
            res++;
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

            check(grid, queen + 1, j, r + 1, row, col, Rdiagonals, ldiagonals, n);

            grid[r][j] = '.';

            row.remove(r);
            col.remove(j);
            Rdiagonals.remove(j - r);
            ldiagonals.remove(j + r);
        }
    }
}