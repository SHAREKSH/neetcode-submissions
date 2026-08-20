class Solution {
    public void rotate(int[] nums, int k) {
        int r=k%nums.length;
        int n =nums.length-1;
        reverse(nums,0,n);
        reverse(nums,0,r-1);
        reverse(nums,r,n);
      

    }

    public void reverse(int [] nums,int i,int j){
        while(i<j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        i++;
        j--;
        }
    }
}