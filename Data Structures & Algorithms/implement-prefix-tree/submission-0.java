class Node{
    Node [] children;
    boolean eow;

    Node(){
        children=new Node[26];
        eow=false;
    }
}

class PrefixTree {
    Node root;

    public PrefixTree() {
         root=new Node();
    }

    public void insert(String word) {
        Node curr=root;
        int len=word.length();

        for(int i=0;i<len;i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            // if(i==len-1){
            //     curr.children[i].eow=true;
            // }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public boolean search(String word) {
        Node curr =root;
        int len=word.length();

        for(int i=0;i<len;i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        int len =prefix.length();

        for(int i=0;i<len;i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return true;
    }
}
