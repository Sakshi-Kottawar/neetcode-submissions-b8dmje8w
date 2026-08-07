class MyHashMap {
    private static final int BUCKET_SIZE = 769;
    private LinkedList<Pair>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKET_SIZE;
    }

    
    public void put(int key, int value) {
        int index=hash(key);
        LinkedList<Pair> list = buckets[index];

        for(Pair p :list){

            if (p.key == key) {
                p.value = value; // update
                return;
            }
        }
        list.add(new Pair(key,value));
        
    }
    
    public int get(int key) {
        int idx=hash(key);
        LinkedList<Pair> list = buckets[idx];

        for(Pair p :list){

            if (p.key == key) {
                return p.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx=hash(key);
        LinkedList<Pair> list = buckets[idx];

        var it = list.iterator();
        while (it.hasNext()) {
            Pair p = it.next();
            if (p.key == key) {
                it.remove();
                return;
            }
        }
    }
}

class Pair{

    int key;
    int value;
    Pair(int key,int value){
        this.key=key;
        this.value=value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

 /*private static final int BUCKET_SIZE = 769;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKET_SIZE;
    }

    
    public void add(int key) {
        int index=hash(key);
        if(!buckets[index].contains(key)){
            buckets[index].add(key);
        }
        
    }
    
    public void remove(int key) {
        int index=hash(key);
        // if(!buckets[index].contains(key)){
            buckets[index].remove((Integer)key);
        // }
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }*/