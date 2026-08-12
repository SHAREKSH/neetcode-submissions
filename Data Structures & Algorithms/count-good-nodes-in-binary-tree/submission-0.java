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
    public int goodNodes(TreeNode root) {
        return traverse(root,Integer.MIN_VALUE);
    }
    public int traverse(TreeNode current,int max){
     if(current==null){
        return 0;
     }  

     
    
     int left=traverse(current.left,Math.max(current.val,max));
     int right=traverse(current.right,Math.max(current.val,max));
     if(current.val>=max){
        return left+right+1;
     }

     return left+right ;
    }
}