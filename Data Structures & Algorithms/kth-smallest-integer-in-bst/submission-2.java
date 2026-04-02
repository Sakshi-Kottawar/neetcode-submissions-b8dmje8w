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
    int cnt=0;
    int small=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return small;
        inorder(root,k);
        return small;
    }

    private void inorder(TreeNode root,int k ){
        if(root==null)return;
        inorder(root.left,k);
        cnt++;
        if(cnt==k){
            small=root.val;
            return;
        } 
        inorder(root.right,k);
    }
}
