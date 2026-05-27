/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node,Node> hm=new HashMap<>();
        Node fnode=new Node(node.val);
        dfs(node,hm,fnode);
        return fnode;
    }

    private void dfs(Node node,HashMap<Node,Node> hm,Node fnode){
        if(hm.containsKey(node)){
            return;
        }
        hm.put(node,fnode);
        for (Node n :node.neighbors){
            if(hm.containsKey(n)){
                fnode.neighbors.add(hm.get(n));
                continue;
            }
            Node newNode=new Node(n.val);
            fnode.neighbors.add(newNode);
            dfs(n,hm,newNode);
        }
    }
}