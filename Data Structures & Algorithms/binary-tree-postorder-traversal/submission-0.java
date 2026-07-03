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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        postorderHelper(res,root);
        return res;
    }
    private void postorderHelper(List<Integer> res,TreeNode root){
        if(root==null)return;
        postorderHelper(res,root.left);
       
        postorderHelper(res,root.right);
 res.add(root.val);

    }
}