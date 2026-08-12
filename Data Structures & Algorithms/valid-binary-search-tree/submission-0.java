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
    public boolean isValidBST(TreeNode root) {
        ;
        return traverse(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean traverse(TreeNode current,long left,long right){
    if(current==null){
        return true;
    }
    if(current.val<=left || current.val>=right){
        return false;
    }
    boolean retval1=traverse(current.left,left,current.val);
    if(!retval1){
     return false;
    }
    boolean retval2=traverse(current.right,current.val,right );
    if(retval2) return true;
    return false;
    }
}