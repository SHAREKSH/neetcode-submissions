class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int maxr=matrix.length;
        int maxc=0;
        int r=0;
        int c=matrix[0].length-1;
        while(r<maxr && c>=maxc){
            if(matrix[r][c]==target) return true;
            else if(matrix[r][c]<target) r+=1;
            else c-=1;
           
        }
        return false;  
    }
}
