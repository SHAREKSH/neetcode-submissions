class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==1){
            if(nums[0]!=val) return 1;
            else return 0; 
        }
        if(nums.length==0) return 0;
        int i=0;
        int j=1;
        int counter=0;
        for(int x:nums){
         if(x==val) counter++;  
        }
        
        while(j<nums.length){
            if(nums[i]==val){
                if(nums[j]!=val){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j++;
                    i++;
                }else{
                    j++;
                }
            }else{
                i++;
                j++;
            }
        }
        return nums.length-counter;
        
    }
}