package leetcode.NeetCode150.HeapPrioriryQueue;

import java.util.*;

public class DesignTwitter355 {

    int timestamp = 0;
    Map<Integer, User> userMap;

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            time = timestamp++;
            next = null;
        }


    }

    class User {
        int userId;
        Tweet tweetHead;
        Set<Integer> followed;

        public User(int userId) {
            this.userId = userId;
            followed = new HashSet<>();
            followed.add(userId);
            tweetHead = null;
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            followed.remove(userId);
        }

        public void postTweet(int tweetId) {
            Tweet t = new Tweet(tweetId);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    public DesignTwitter355() {
          userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
          if (!userMap.containsKey(userId)) {
              userMap.put(userId, new User(userId));
          }
          userMap.get(userId).postTweet(tweetId);

    }

    // O(N * log N)
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        if (!userMap.containsKey(userId)) return result;

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> (b.time - a.time));
        Set<Integer> followedList = userMap.get(userId).followed;

        for (int followee : followedList) {
            Tweet tH = userMap.get(followee).tweetHead;
            maxHeap.add(tH);
        }

        int n = 0;
        while (!maxHeap.isEmpty() && n < 10) {
            Tweet curr = maxHeap.poll();
            result.add(curr.tweetId);
            n++;

            if (curr.next != null) {
                maxHeap.add(curr.next);
            }

        }

        return result;

    }

    public void follow(int followerId, int followeeId) {
           if (!userMap.containsKey(followerId)) {
               userMap.put(followerId, new User(followerId));
           }

           if (!userMap.containsKey(followeeId)) {
               userMap.put(followeeId, new User(followeeId));
           }

           userMap.get(followerId).follow(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
           if (!userMap.containsKey(followerId) || followerId == followeeId) {
               return;
           }
           userMap.get(followerId).unfollow(followeeId);

    }
}
