class Solution {
    public int[] getConcatenation(int[] nums) {
        int op[]=new int[2*nums.length];

        for(int i=0;i<op.length;i++){
            op[i]=nums[i%nums.length];
        }
        return op;
    }
}