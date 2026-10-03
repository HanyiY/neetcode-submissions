class Twitter {
    int timestamp;
    Map<Integer, Set<Integer>> followeeMap;
    Map<Integer, List<Integer>> userToTweets;
    Map<Integer, Integer> tweetToTimestamp;
    PriorityQueue<Integer> maxHeap;

    public Twitter() {
        timestamp = 0;
        followeeMap = new HashMap<>();
        userToTweets = new HashMap<>();
        tweetToTimestamp = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        tweetToTimestamp.put(tweetId, timestamp);

        userToTweets.putIfAbsent(userId, new ArrayList<>());
        userToTweets.get(userId).add(tweetId);

    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(tweetToTimestamp.get(b), tweetToTimestamp.get(a)));
        // List<Integer> list1 = userToTweets.get(userId);
        // for (int i: followeeMap.get(userId)) {
        //     list1.addAll(userToTweets.get(i));
        // }

        // for (int t: list1) {
        //     maxHeap.offer(t);
        // }
        for (int t : userToTweets.getOrDefault(userId, Collections.emptyList())) {
            maxHeap.offer(t);
        }
        for (int f : followeeMap.getOrDefault(userId, Collections.emptySet())) {
            for (int t : userToTweets.getOrDefault(f, Collections.emptyList())) {
                maxHeap.offer(t);
            }
        }

        int n = 0;
        while (!maxHeap.isEmpty() && n < 10) {
            res.add(maxHeap.poll());
            n++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followeeMap.putIfAbsent(followerId, new HashSet<>());
        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followeeMap.putIfAbsent(followerId, new HashSet<>());
        followeeMap.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
