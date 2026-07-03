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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preorderHelper(res,root);
        return res;
    }
    private void preorderHelper(List<Integer> res,TreeNode root){
        if(root==null)return;
 res.add(root.val);
        preorderHelper(res,root.left);
       
        preorderHelper(res,root.right);
    }
}