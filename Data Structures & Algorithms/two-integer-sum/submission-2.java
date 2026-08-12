class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(Integer num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int arr[]={0,0};
        int counter=-1;
        for(Integer num:nums){
            counter++;
            int possible=target-num;
            if(map.containsKey(possible)){
                if(num==possible && map.get(possible)<=1) continue;
                arr[0]=counter;
                for(int i=0;i<nums.length;i++){
                    if(nums[i]==possible && i!=counter) arr[1]=i;
                }
                break;

            }
            }
             return arr;
        }
   
    }


