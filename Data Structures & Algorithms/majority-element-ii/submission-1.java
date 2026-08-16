class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int var1=nums[0];
        int var1_count=0;
        int var2=0;
        int var2_count=0;
        for(int num:nums){
            if(var1!=num){
                var2=num;
                break;
            }
        }
        
        for(int num:nums){

            if(var1_count==0|| num==var1){
                var1=num;
            }else if(var2_count==0||num==var2){
                var2=num;
            }
            if(num==var1){
                var1_count++;
            }
           else if(num==var2){
                var2_count++;
            }else{
              var1_count--;
              var2_count--;
            }
        }

        System.out.println(var1+"-"+var2);
        List<Integer> op=new ArrayList<>();
        int threshold=nums.length/3;
        System.out.println(threshold);
        int count=0;
        for(int num:nums){
           if(var1==num){
            count++;
          }
          if(count>threshold){ 
            op.add(var1);
           break;}

        }
        count=0;
        for(int num:nums){
                if(var2==num){
            count++;
          }
            if(count>threshold) {
            op.add(var2);
             break;}
 
        }
        return op;
    }
}