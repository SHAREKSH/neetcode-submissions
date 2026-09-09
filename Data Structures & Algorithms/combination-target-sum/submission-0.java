class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>op=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        find(nums,op,temp,0,0,target);
        return op;
    }
    public void find(int [] nums,List<List<Integer>>op,List<Integer> temp,int i,int sum,int target){
        if(sum==target){
            op.add(new ArrayList<>(temp));
            return;
        }else if(sum>target) return;

        for(int j=i;j<nums.length;j++){
            temp.add(nums[j]);
            find(nums,op,temp,j,sum+nums[j],target);
            temp.remove(temp.size()-1);
        }
    }
}
