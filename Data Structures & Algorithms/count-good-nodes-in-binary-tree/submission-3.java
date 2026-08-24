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
    int noOfGoodNodes=0;
    public int goodNodes(TreeNode root) {
        if(root==null)return 0;
        helper(root,root.val);
        return noOfGoodNodes;
    }

    private void helper(TreeNode root,int max){
        if(root==null)return;
        // System.out.println("root" +root);
        // System.out.println("max" +max);
        if(root.val>=max)noOfGoodNodes++;
        if(root.left!=null)
            helper(root.left,Math.max(max,root.left.val));
        if(root.right!=null)
            helper(root.right,Math.max(max,root.right.val));
    }
}
