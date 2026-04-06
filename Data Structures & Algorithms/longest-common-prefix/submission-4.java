class Node{
    Node[] children;
    boolean eow;
    int childCount=0;

    Node(){
        eow=false;
        children=new Node[26];
    }
}
class Trie{
    Node root;

    Trie(){
        root=new Node();
    }

    void insert(String word){
        Node curr=root;
        int len=word.length();

        for(int i=0;i<len;i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
                curr.childCount++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
}

class Solution {
    

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        Trie trie = new Trie();
        for (String s : strs) {
            if (s.isEmpty()) return ""; // Optimization: if any string is empty, LCP is ""
            trie.insert(s);
        }

        StringBuilder sb=new StringBuilder();
        Node curr=trie.root;
        String word=strs[0];
        int j=0;
        while(j<word.length()){
            int idx=word.charAt(j)-'a';

             if (curr.children[idx] != null && curr.childCount == 1 && !curr.eow) {
                sb.append(word.charAt(j));
                curr = curr.children[idx]; // Move to the character's node
                j++;
            } else {
                // We hit a branch, an end-of-word, or a mismatch
                break;
            }
        }
    return sb.toString();
    }


}







