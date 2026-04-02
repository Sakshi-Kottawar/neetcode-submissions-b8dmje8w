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
    // public boolean isBalanced(TreeNode root) {
    //     if(root==null)return true;
    //     int left=height(root.left);
    //     int right=height(root.right);
    //     return isBalanced(root.left) && isBalanced(root.right) && ((Math.abs(left-right)==1) || (left==right));
        
    // }

    // private int height(TreeNode root){
    //     if(root==null) return 0;
    //     return 1+Math.max(height(root.left),height(root.right));
    // }




    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return height(root)!=-1;
    }

    private int height(TreeNode root){
        if(root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1)return -1;
        return 1+Math.max(left,right);
    }
}
