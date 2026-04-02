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
    /*
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        int diamL=diameterOfBinaryTree(root.left);
        int diamR=diameterOfBinaryTree(root.right);
        return Math.max(left+right,Math.max(diamL,diamR));
    }

     public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }
    */
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        max = Math.max(max, left + right);  
        
        return 1 + Math.max(left, right);
    }

}
