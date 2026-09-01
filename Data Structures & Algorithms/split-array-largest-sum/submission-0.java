class Solution {
    public int splitArray(int[] nums, int k) {

        int sum1=0;
        int max=nums[0];
        for (int i : nums) {
            sum1=sum1+i;
            if(i>max){
                max=i;
            }
            
        } 
    return search(nums, max, sum1, k);
        
    }
    
  public static  int search(int[] nums,int start,int end,int m){

   
    while(start<end){
        
    int mid=start + (end-start)/2;
    int count=1;
    int sum=0;

    for (int element:nums){
        if(sum+element<=mid){
            sum=sum+element;
        }
        else{
            sum=element;
            count=count+1;
        }
        
    }
       if(count<=m){
         end=mid;

       }
       else{
        start=mid+1;

       }
   

    }


    return start;

  }
}