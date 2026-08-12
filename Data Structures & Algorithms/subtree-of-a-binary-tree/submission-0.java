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
   String fulltree="";
   String subtree="";
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs1(root);
        dfs2(subRoot);
        // System.out.println(fulltree);
        // System.out.println(subtree);
        if(fulltree.contains(subtree)) return true;

        return false;
    }

    public void dfs1(TreeNode node ){
        if(node==null){
            fulltree+="#";
            return;
        }
        fulltree+="[";
        fulltree+=node.val;
        fulltree+="]";
        dfs1(node.left);
        dfs1(node.right);

    }
        public void dfs2(TreeNode node ){
        if(node==null){
            subtree+="#";
            return;
        }
        subtree+="[";
        subtree+=node.val;
        subtree+="]";
        dfs2(node.left);
        dfs2(node.right);

    }
}