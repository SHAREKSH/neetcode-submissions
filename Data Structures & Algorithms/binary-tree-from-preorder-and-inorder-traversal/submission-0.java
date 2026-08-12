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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[]root={0};
       return build(inorder,root,preorder,0,inorder.length-1);
    }

    public TreeNode build(int[] inorder,int[]root,int[] preorder,int start ,int end){
    if(root[0]>=preorder.length || end<start){
        return null;
    }
    TreeNode rot=new TreeNode(preorder[root[0]]);
    int inorder_root=0;
    for(int i=start;i<=end;i++){
        if(inorder[i]==preorder[root[0]]){
            inorder_root=i;
            break;
        }
    }
    root[0]++;
    rot.left=build(inorder,root,preorder,start,inorder_root-1);
    if(rot.left==null) root[0]--;
    root[0]++;
    rot.right=build(inorder,root,preorder,inorder_root+1,end);
    if(rot.right==null) root[0]--;
    return rot;

    }
}