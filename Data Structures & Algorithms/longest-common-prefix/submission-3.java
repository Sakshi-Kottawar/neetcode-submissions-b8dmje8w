class Node{
    Node[] children;
    boolean eow;

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
            if(curr.children[idx]==null)
                curr.children[idx]=new Node();
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        Trie trie=new Trie();
        
        trie.insert(strs[0]);
        StringBuilder sb=null;
        for(int i=1;i<strs.length;i++){
            Node curr=trie.root;
            int len=strs[i].length();
            if(len==0)return "";
            String word=strs[i];
            sb=new StringBuilder();
            for(int j=0;j<len;j++){
                int idx=word.charAt(j)-'a';
                if(curr.children[idx]!=null && curr.eow!=true){
                    sb.append((char)(idx+'a'));
                    curr=curr.children[idx];
                }else{
                    // curr.eow=true;
                    break;
                }
                
            }
            curr.eow=true;
        }
        return sb.toString();

    }
}