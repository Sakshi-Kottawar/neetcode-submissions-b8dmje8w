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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                TreeNode tmp=q.poll();
                if(i==size-1)
                    res.add(tmp.val);
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!=null) q.add(tmp.right);
            }
        }
        return res;
    }
}
