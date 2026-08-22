class Solution {
    public int maxArea(int[] heights) {
        int res=0;
        int i=0;
        int j=heights.length-1;

        while(i<j){
        int area=Math.min(heights[i],heights[j])*(j-i);
        res=Math.max(res,area);
        if(heights[i]<=heights[j]) i++;
        else j--;
        }
        return res;
    }
}
