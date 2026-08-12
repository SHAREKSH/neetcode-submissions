/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode temp;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result=new TreeNode[1];
        result[0]=root;
        traverse(root,p,q,result);
        return temp;
    }
    public boolean traverse(TreeNode current,TreeNode p, TreeNode q,TreeNode[] result){
    
    if(current==null){
        return false;
    }
    boolean retval1=traverse(current.left,p,q,result);
    boolean retval2=traverse(current.right,p,q,result);
    if(retval1 && retval2){
        result[0]=current;
        temp=current;
        return true;
    }
    if((current==p || current==q)&&(retval1 || retval2)){
        result[0]=current;
        temp=current;
        return true;
    }
    if((current==p || current==q)||(retval1 || retval2)){
        return true;
    }

    return false;  


    

    }
}