class Solution {
    public int[] sortArray(int[] nums) {
     Thread sortThread = new Thread(()-> heap(nums));
        sortThread.start();
        try{
            sortThread.join();
        }catch(Exception e){

        }
    return nums;
          
    }

    public void heap(int[] nums){
    int length=nums.length;

    //Heap Top tp down  Heap construction   -- O(nlogn)
        // for(int i=0;i<length;i++){
        // int left=i*2+1;
        // int right=i*2+2;

        // if(left<length){
        //   heapUp(nums,left);
        // }
        // if(right<length){
        //   heapUp(nums,right);
        // }
        // }
  //Bottom -up heap  construction  floyd algo -- O(n)   beacuse  leaf nodes  have n/2  nodes  max  nodes have to do less work in heap down  ans compared to heap up in top down approach  
  
        for(int i=(length/2)-1;i>=0;i--){
            heapdown(nums,length,i);
        }

        

        length=nums.length;
        for(int i=1;i<nums.length;i++){
        swap(nums,0,length-1);
        heapdown(nums,length-1,0);
        length=length-1;
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void heapUp(int[] nums,int index){
        int parent=(index-1)/2;
        while(parent>=0){
            if(nums[index]>nums[parent]){
                swap(nums,index,parent);
                if(parent==0) break;
                index=parent;
                parent=(parent-1)/2;  
            }else{
                break;
            }
        }
    }

    public void heapdown(int nums[],int length,int index){
           while(index<length){

         
            int left=index*2 +1;
            int right=index*2+2;

            if(left<length && right<length && nums[left]>=nums[right]){
               if(nums[index]<nums[left]){
                swap(nums,left,index);
                index=left;
               }else break;
            }else if(left<length && right<length && nums[left]<nums[right]){
               if(nums[index]<nums[right]){
                swap(nums,right,index);
                index=right;
               }else break;
            }else if (left<length && nums[left]>nums[index]){
                swap(nums,left,index);
                index=left;
            }else if (right<length && nums[right]>nums[index]){
                swap(nums,right,index);
                index=right;
            }else{
                break;
            }
           }
    }

    
}