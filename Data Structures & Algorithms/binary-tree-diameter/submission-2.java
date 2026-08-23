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
    public int diameterOfBinaryTree(TreeNode root) {
       if(root==null) return 0;

       int leftDiam=diameterOfBinaryTree(root.left);
       int rightDiam=diameterOfBinaryTree(root.right);

        int leftH=height(root.left);
        int rightH=height(root.right);

        int maxDiam= Math.max(leftDiam,rightDiam);

        return Math.max(leftH+rightH,maxDiam);

    }

    private int height(TreeNode root){
        if(root==null)return 0;
        int leftH=height(root.left);
        int rightH=height(root.right);
        return 1+Math.max(leftH,rightH);
    }
}
