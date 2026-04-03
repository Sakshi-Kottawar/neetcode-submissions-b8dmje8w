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



/*Using level order traversal*/

/*
import java.util.*;

public class Codec {
    private static final String delim = ",";
    private static final String nullM = "#";

    // 1. Serialize: Level-by-level using a Queue
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append(nullM).append(delim);
                continue;
            }
            sb.append(node.val).append(delim);
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // 2. Deserialize: Reconstruct level-by-level using a Queue
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] vals = data.split(delim);
        
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // 'i' keeps track of the children in the vals array
        for (int i = 1; i < vals.length; i++) {
            TreeNode parent = q.poll();
            
            // Process Left Child
            if (!vals[i].equals(nullM)) {
                parent.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(parent.left);
            }
            
            // Process Right Child
            i++; // Move to the next value for the right child
            if (i < vals.length && !vals[i].equals(nullM)) {
                parent.right = new TreeNode(Integer.parseInt(vals[i]));
                q.add(parent.right);
            }
        }
        return root;
    }
}
*/
