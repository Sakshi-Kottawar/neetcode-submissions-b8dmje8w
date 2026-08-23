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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)return root;

        boolean leftSearch=search(root.left,p,q);
        boolean rightSearch=search(root.right,p,q);

        if(leftSearch && rightSearch)
            return root;

        if(leftSearch)
            return lowestCommonAncestor(root.left,p,q);
        if(rightSearch)
            return lowestCommonAncestor(root.right,p,q);
        return null;
    }

    private boolean search(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return false;
        boolean leftS=search(root.left,p,q);
        boolean rightS=search(root.right,p,q);
        if(root.val==p.val || root.val==q.val)return true;
        return leftS||rightS;
    }
}
