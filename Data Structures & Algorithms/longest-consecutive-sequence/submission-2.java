class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        for(int num:set){
            if(!set.contains(num-1)){
                int count=1;
                int x=num+1;
                while(set.contains(x)){
                count++;
                x++;
                }
            res= Math.max(res,count);
            }
        }
        return res;
        
    }
}
