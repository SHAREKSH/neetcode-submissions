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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
    findmaxdepth(root);
    return max;
    }
    public int findmaxdepth(TreeNode current){
     if(current==null)return 0;
     int retval1=findmaxdepth(current.left);
     int retval2=findmaxdepth(current.right);
     max=Math.max(max,retval1+retval2);
     return Math.max(retval1,retval2)+1;

    }
}