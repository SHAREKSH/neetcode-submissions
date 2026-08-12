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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }
    public int traverse(TreeNode current){
        if(current==null){
            return 0;
        }

        int left=traverse(current.left);
        int right=traverse(current.right);


       // Three possiblites- 1.Sum of all Three || 2.Sum of two either root+left or root+right || 3. root value
        max=Math.max(max,left+right+current.val);
        int Tempmax=Math.max(left+current.val,right+current.val);
        int final_max=Math.max(Tempmax,current.val);
        max=Math.max(max,final_max);  

        return final_max;

    }
}