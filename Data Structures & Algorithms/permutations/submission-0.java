class Solution {
    public List<List<Integer>> permute(int[] nums) {

        int[] visited=new int[nums.length];
        List<List<Integer>> op=new ArrayList<>();
        List<Integer>processed=new ArrayList<>();
        Search(op,visited,nums,0,processed);
        return op;

        
    }
    public void Search(List<List<Integer>> op,int[] visited,int []nums,int j,List<Integer>processed){
        if(processed.size()==nums.length){
            op.add(new ArrayList<>(processed));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==1) continue;
            processed.add(nums[i]);
            visited[i]=1;
            Search(op,visited,nums,i+1,processed);
            processed.remove(processed.size()-1);
            visited[i]=0;
        }
    }
}
