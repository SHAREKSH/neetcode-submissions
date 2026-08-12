/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        if(root==null){
            return op;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=1;i<=size;i++){
                TreeNode poped=q.poll();
                if(i==size){
                    op.add(poped.val);
                }
                if(poped.left!=null){
                 q.offer(poped.left);
                }if(poped.right!=null){
                 q.offer(poped.right);
                }

            }
        }
        return op;
    }
}
