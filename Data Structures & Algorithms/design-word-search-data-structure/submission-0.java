class Node{
    Node[] children;
    boolean eow;

    Node(){
        children=new Node[26];
        eow=false;
    }
}


class WordDictionary {
    Node root;

    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        Node curr=root;
        int len =word.length();
        
        for(int i=0;i<len;i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public boolean search(String word) {
       return searchInNode(word,0,root);
    }

    private boolean searchInNode(String word,int index,Node curr){
        if(word.length()==index)return curr.eow;

        char c=word.charAt(index);
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(curr.children[i]!=null){
                    if(searchInNode(word,index+1,curr.children[i]))
                        return true;
                }
            }
            return false;
        }else{
            int idx=word.charAt(index)-'a';
            if(curr.children[idx]==null)
                    return false;
            else
                return searchInNode(word,index+1,curr.children[idx]); 
        }
    }
}
