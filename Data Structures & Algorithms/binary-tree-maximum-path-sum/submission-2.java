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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;         
        // int left=height(root.left);
        // int right=height(root.right);
        // int l=maxPathSum(root.left);
        // int r=maxPathSum(root.right);
        // return Math.max(root.val+left+right,Math.max(l,r));
        height(root);
        return max;
    }

    private int height(TreeNode root){
        if(root==null)return 0;
        int left=Math.max(0,height(root.left));
        int right=Math.max(0,height(root.right));
        max=Math.max(max,root.val+left+right);
        return root.val+Math.max(left,right);
    }
}
