class Solution {
    public int[] productExceptSelf(int[] nums) {

      // Approach  with division with complexity  O(n) and space O(1)
      //  case 1  -  zeros are 0 --  find prouct of all array and put in  index  by diving current elment
      // case 2-  zeroes  exactly 1 find product of all array exculding zero and put in the index where we have 0 and for rest put 0

      // case 3=  2 or more zeros  put every index  zero



        
        // Approach with Time:O(n) & Space:O(n)  without using division  ,costing space
        int[] Left_to_Right=new int[nums.length];
        int[] Right_to_Left=new int[nums.length];

        //Forward prefix product 
        Left_to_Right[0]=nums[0];
        for(int i=1;i<nums.length;i++) Left_to_Right[i]=Left_to_Right[i-1]*nums[i];
        
        //Backward suffix product
        Right_to_Left[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>0;i--) Right_to_Left[i]=Right_to_Left[i+1]*nums[i];
        
        int[] op=new int[nums.length];
        op[0]=Right_to_Left[1];
        op[nums.length-1]=Left_to_Right[nums.length-2];
        for(int i=1;i<nums.length-1;i++) op[i]=Left_to_Right[i-1]*Right_to_Left[i+1];
        return op;
    }
}  
