class TimeMap {
    Map<String,List<Pair>> hm;

    public TimeMap() {
        hm=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key))return "";
        List<Pair> valuesList=hm.get(key);
        int size=valuesList.size();
        int low=0;
        int high=size-1;
        String res="";
        while(low<=high){
            int mid=low+(high-low)/2;
            String value = valuesList.get(mid).value;
            int mtime = valuesList.get(mid).timestamp;
            if(mtime==timestamp){
                return value;
            }else if(mtime<timestamp){
                res=value;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return res;
    }
}
class Pair{
    String value;
    int timestamp;

    Pair(String value,int timestamp){
        this.value=value;
        this.timestamp=timestamp;
    }
}
