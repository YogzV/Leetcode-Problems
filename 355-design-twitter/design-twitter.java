class Twitter {

    Map<Integer,HashSet<Integer>> followMap;
    Map<Integer,List<int[]>> tweetMap;
    int time;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k -> new ArrayList<>()).add(new int[]{time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Queue<int[]> pqueue = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        followMap.computeIfAbsent(userId,k -> new HashSet<>()).add(userId);

       for(int followeeId : followMap.get(userId)){
        if(tweetMap.containsKey(followeeId)){
            List<int[]> tweets = tweetMap.get(followeeId);
            int index = tweets.size() -1;
            int[] tweet = tweets.get(index);
            pqueue.offer(new int[]{tweet[0],tweet[1],followeeId,index});
        }
       }

       while(!pqueue.isEmpty() && res.size() < 10){
         int[] pt = pqueue.poll();
         res.add(pt[1]);
         int index = pt[3] - 1;
         if(index >= 0){
            int[] tweet = tweetMap.get(pt[2]).get(index);
            pqueue.offer(new int[]{tweet[0],tweet[1],pt[2],index});
         }
       }

       return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId,(k,v) -> {
            v.remove(followeeId);
            return v;
    });
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */