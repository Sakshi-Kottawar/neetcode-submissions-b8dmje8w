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
    private int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return build(preorder,inorderMap,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> inorderMap,int p,int q){
        if(p>q)return null;

        TreeNode root=new TreeNode(preorder[preIndex++]);

        int rootIndex=inorderMap.get(root.val);

        root.left=build(preorder,inorderMap,p,rootIndex-1);
        root.right=build(preorder,inorderMap,rootIndex+1,q);
        return root;
    }
}
