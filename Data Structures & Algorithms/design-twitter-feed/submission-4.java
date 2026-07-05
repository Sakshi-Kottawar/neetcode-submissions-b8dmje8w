class Twitter {

    Map<Integer,Set> followeeMap;
    Map<Integer,List<Pair>> tweetMap;
    int time;


    public Twitter() {
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {

        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new Pair(time,tweetId));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users=followeeMap.get(userId);

        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a,b)->b.time-a.time);
        if(users==null)
            users=new HashSet<>();
        users.add(userId);

        for(int uid:users){
            List<Pair> tweets=tweetMap.get(uid);
            if(tweets==null)continue;

            for(int i=tweets.size()-1;i>=0 && i>=tweets.size()-10;i--){
                maxHeap.add(tweets.get(i));
            }

        }

        List<Integer> result=new ArrayList<>();
        while(!maxHeap.isEmpty() && result.size()<10){
            result.add(maxHeap.poll().tweetId);

        }

        return result;


    }
    
    public void follow(int followerId, int followeeId) {
        followeeMap.putIfAbsent(followerId, new HashSet<>());
        followeeMap.get(followerId).add(followeeId);   
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> hs=followeeMap.get(followerId);
        if(!hs.isEmpty() && hs.contains(followeeId)){
            hs.remove(followeeId);
            followeeMap.put(followerId,hs);
        }
    }
}
class Pair{
    int time;
    int tweetId;

    Pair(int time,int tweetId)
    {
        this.time = time;
        this.tweetId = tweetId;
    }
}
