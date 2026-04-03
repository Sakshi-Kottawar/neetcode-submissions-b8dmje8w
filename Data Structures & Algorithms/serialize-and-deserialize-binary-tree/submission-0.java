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

public class Codec {

    private static final String delim = ",";
    private static final String nullM = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        buildString(root,sb);
        return sb.toString();

    }

    private void buildString(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(nullM).append(delim);
            return ;
        }
        sb.append(root.val).append(delim); 
        buildString(root.left,sb);
        buildString(root.right,sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        // Use a Queue to keep track of which value we are currently processing
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(delim)));
        return buildTree(nodes);
        
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(nullM)) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);  // Recursively build entire left side
        node.right = buildTree(nodes); // Then build entire right side
        return node;
    }
}
