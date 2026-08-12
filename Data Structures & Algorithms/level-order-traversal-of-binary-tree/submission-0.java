
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> op = new ArrayList<>();
        if(root==null){
            return op;
        }

        Queue<TreeNode> store = new LinkedList<>();
        store.offer(root);

        while (!store.isEmpty()) {
            List<Integer> seq = new ArrayList<>();
            int size=store.size();
            for (int i = 0; i <size; i++) {
                TreeNode r = store.poll();
                seq.add(r.val);

                if (r.left != null) {
                    store.offer(r.left);
                }
                if (r.right != null) {
                    store.offer(r.right);
                }
            }
            op.add(seq);
        }
    return op;
    }

}
