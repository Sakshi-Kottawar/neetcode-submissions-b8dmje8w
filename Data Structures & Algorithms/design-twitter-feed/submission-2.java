//view most 10 recent tweets
//follow and unfollow each other

//userId->tweets
//userId-->followers
class Tweet implements Comparable<Tweet>{
    int tweetId;
    int time;

    Tweet(int id,int t){
        this.tweetId=id;
        this.time=t;
    }

    public int  compareTo(Tweet that){
        return that.time-this.time;
    }
}       

class User{
    int userId;
    List<Tweet> tweets;
    HashSet<Integer> followers;

    User(int userId){
        this.userId = userId;
        followers = new HashSet<>();
        followers.add(userId);//add self also as follower;
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t){
        tweets.add(0,t); //insertion at the head
    }

    
}

class Twitter {
    //mapping of userId to User
    HashMap<Integer,User> hm;
    int time;

    public Twitter() {
        hm=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!hm.containsKey(userId)){
            User user=new User(userId);
            hm.put(userId,user);
        }
        User user1=hm.get(userId);
        user1.addTweet(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>();
        if(!hm.containsKey(userId)){
           return new ArrayList<>();
        }
        User user=hm.get(userId);
        int cnt=0;
       
        for(Integer followerId: user.followers){

            User follower=hm.get(followerId);
            for(Tweet tweet: follower.tweets){
                if(cnt>10)break;
                cnt++;
                pq.add(tweet);
            
            }           
        }
        List<Integer> res = new ArrayList<>();
        int index=0;
        while(!pq.isEmpty() && index<10){
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            index++;
        }
        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        hm.putIfAbsent(followerId, new User(followerId));
        hm.putIfAbsent(followeeId, new User(followeeId));
        User u=hm.get(followerId);
        u.followers.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!hm.containsKey(followerId) || !hm.containsKey(followeeId)){
           return;
        }
        if (followerId == followeeId) return; // Cannot unfollow self
        if (hm.containsKey(followerId)) {
        hm.get(followerId).followers.remove(followeeId);
    }
    }
}
