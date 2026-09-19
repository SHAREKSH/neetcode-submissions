class Solution {

    public boolean exist(char[][] grid, String pattern) {

        int r = grid.length;
        int c = grid[0].length;

        int[][] visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid[i][j] == pattern.charAt(0)) {

                    if (find(visited, grid, pattern, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean find(int[][] visited, char[][] grid,
                               String pattern, int r, int c, int checked) {

        if (checked == pattern.length()) {
            return true;
        }

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            visited[r][c] == 1) {
            return false;
        }

        char temp = grid[r][c];

        visited[r][c] = 1;

        if (temp == pattern.charAt(checked)) {

            boolean t =
                find(visited, grid, pattern, r + 1, c, checked + 1) ||
                find(visited, grid, pattern, r - 1, c, checked + 1) ||
                find(visited, grid, pattern, r, c + 1, checked + 1) ||
                find(visited, grid, pattern, r, c - 1, checked + 1);

            visited[r][c] = 0;

            return t;
        }

        visited[r][c] = 0;

        return false;
    }
}