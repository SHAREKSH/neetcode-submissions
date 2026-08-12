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

    //boolean found=false;
    public TreeNode deleteNode(TreeNode root, int key) {
    return find(root,key);
    }
   // Recursion + itertaor  --Simple and less complex

    public TreeNode find(TreeNode current, int val) {

        if (current == null) {
            return null;
        }

        if(current.val==val){
          TreeNode iterator=current.right;
          while(iterator!=null && iterator.left!=null){
            iterator=iterator.left;
          }
          if(iterator!=null){
            iterator.left=current.left;
            return current.right;
          }else{
            return current.left;
          }
        }
        if (val < current.val) {
            current.left=find(current.left, val);
        } else {
            current.right=find(current.right, val);
        }
        
        return current;
    }





    // Recursive

    // public TreeNode find(TreeNode current, int val) {

    //     if (current == null) {
    //         return null;
    //     }

    //     if(current.val==val){

    //         found=true;
    //         if(current.right==null){
    //          return current.left;
    //         }
    //       TreeNode op=find(current.right,val);
    //        op.left=current.left;
    //        return current.right;

    //     }
    //     if(found==false){
    //     if (val < current.val) {
    //         current.left=find(current.left, val);
    //     } else {
    //         current.right=find(current.right, val);
    //     }
    //     }else{
    //       TreeNode res=find(current.left,val);
    //       if(res==null){
    //         return current;
    //       }
    //       return res;
    //     }
    //     return current;
    // }
}