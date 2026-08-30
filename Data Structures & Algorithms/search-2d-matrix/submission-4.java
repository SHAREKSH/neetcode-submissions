class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int maxr=matrix.length;
        // int maxc=0;
        // int r=0;
        // int c=matrix[0].length-1;
        // while(r<maxr && c>=maxc){
        //     if(matrix[r][c]==target) return true;
        //     else if(matrix[r][c]<target) r+=1;
        //     else c-=1;
           
        // }
        // return false;  

        int l=1;
        int r=matrix.length*matrix[0].length;
        int trows=matrix.length;
        int tcols=matrix[0].length;

        while(l<=r){
            int mid=l+(r-l)/2;
            int row=getrow(mid,tcols);
            int col=(mid-1)%tcols;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) l=mid+1;
            else r=mid-1;
        }
        return false;
    }
    public int getrow(int x,int n){
        if(x%n==0) return (x/n)-1;
        else return x/n;
    }
}
