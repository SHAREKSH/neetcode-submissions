class NumMatrix {
    int[][] matrix;
    int[][] prefix_sum_matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        prefix_sum_matrix=generate_prefix(matrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    // for making as per our prefix array  increase due to padding addtion in prefix array but index are acc to normal array.
    row1+=1;
    row2+=1;
    col1+=1;
    col2+=1;
    int area=prefix_sum_matrix[row2][col2]-prefix_sum_matrix[row1-1][col2]-prefix_sum_matrix[row2][col1-1]+prefix_sum_matrix[row1-1][col1-1];

    
    return area;
     }

    public int[][] generate_prefix(int[][] matrix){

        // +1 for making 1st row and 1st column as 0 for padding,to reduce checks of index out of bounds.
        int row_len=matrix.length+1;
        int col_len=matrix[0].length+1;
        int [][] op=new int[row_len][col_len];

        for(int row=1;row<row_len;row++){
            for(int col=1;col<col_len;col++){
            op[row][col]=matrix[row-1][col-1]+op[row-1][col]+op[row][col-1] -op[row-1][col-1];
            }
        }
        return op;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */