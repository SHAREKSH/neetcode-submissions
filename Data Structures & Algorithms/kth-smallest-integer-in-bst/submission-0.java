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

    int smallest_counter=0;
    int smallest=-1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return smallest;
    }
    public void inorder(TreeNode current,int k){
        if(current==null){
            return;
        }
         inorder(current.left,k);
         if(++smallest_counter==k){
          smallest=current.val;
          return;
         }
         if(smallest==-1){
         inorder(current.right,k);}
         return ;
    }
}