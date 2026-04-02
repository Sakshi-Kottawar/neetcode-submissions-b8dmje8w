class LRUCache {
    int capacity;
    HashMap<Integer,DLL> hm=new HashMap<>();
    DLL head=new DLL();
    DLL tail=new DLL();


    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            DLL tmp=hm.get(key);
            removeNode(tmp);
            addMRU(tmp);
            return tmp.val;
        } 
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            //removethat key
            DLL tmp=hm.get(key);
            tmp.val=value;
            removeNode(tmp);
            addMRU(tmp);
        }
        else {
            if(hm.size()>=capacity){
                //remove lru from the back;
                DLL next1=head.next;
                removeNode(next1);
                hm.remove(next1.key);
            }
                //insert new node         
            DLL tmp =new DLL(key,value);
            addMRU(tmp);
            hm.put(key,tmp);   
        }
         
    }
    private void removeNode(DLL tmp){
            DLL prev1=tmp.prev;
            DLL next1=tmp.next;
            prev1.next=next1;
            next1.prev=prev1;
    }

    private void addMRU(DLL node){
        DLL prev1 =tail.prev;
        tail.prev=node;
        node.next=tail;
        node.prev=prev1;
        prev1.next=node;
    }
}
class DLL{
    int key;
    int val;
    DLL prev;
    DLL next;
    DLL(){
        this.key=0;
        this.val=0;
        prev=null;
        next=null;
    }
    DLL(int key,int val){
        this.key=key;
        this.val=val;
        prev=null;
        next=null;
    }

}
