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
     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;

        if(isSameTree(root,subRoot))return true;

        boolean left = isSubtree(root.left,subRoot);
        boolean right= isSubtree(root.right,subRoot);

        return (left || right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;

        if(p==null || q==null)return false;

        boolean leftSame=isSameTree(p.left,q.left);
        boolean rightSame=isSameTree(p.right,q.right);
        return (p.val==q.val) && leftSame && rightSame;
    }
}
