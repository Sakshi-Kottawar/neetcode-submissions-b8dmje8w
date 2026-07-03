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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;

        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else{
            //we have found the node

            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            //node has bothe left and right child
            TreeNode successor=findMin(root.right,key);

            root.val=successor.val;

            root.right=deleteNode(root.right,successor.val);



        }
        return root;
    }

    private TreeNode findMin(TreeNode root, int key){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}