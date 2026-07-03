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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorderHelper(res,root);
        return res;
    }
    private void inorderHelper(List<Integer> res,TreeNode root){
        if(root==null)return;

        inorderHelper(res,root.left);
        res.add(root.val);
        inorderHelper(res,root.right);
    }
}