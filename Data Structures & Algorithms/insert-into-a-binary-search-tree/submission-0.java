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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        return insert(root,val);
    }
    public TreeNode  insert(TreeNode current,int val){

        if(current==null){
            TreeNode node=new TreeNode(val);
            return node;
        }

        if(val<current.val){
            current.left=insert(current.left,val);
        }else{
            current.right=insert(current.right,val);
        }
        return current;
    }
}




