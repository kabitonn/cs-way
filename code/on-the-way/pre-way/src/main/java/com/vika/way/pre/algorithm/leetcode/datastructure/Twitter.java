package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.*;

/**
 * 355. 设计推特
 *
 * @author tokabi
 * @date 2019/10/29 19:53
 */
public class Twitter {

    public static int timestamp = 1;
    public static int tweetNum = 10;
    Map<Integer, User> userMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followings or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(tweetNum + 1, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.timestamp - o2.timestamp;
            }
        });
        Set<Integer> followings = userMap.get(userId).getFollowings();
        for (int id : followings) {
            List<Tweet> tweets = userMap.get(id).getTweets();
            for (int i = 0; i < tweets.size() && i < tweetNum; i++) {
                if (minHeap.size() < tweetNum) {
                    minHeap.add(tweets.get(i));
                } else {
                    minHeap.add(tweets.get(i));
                    minHeap.poll();
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            list.add(0, minHeap.poll().getTweetId());
        }
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        User follower = userMap.get(followerId);
        follower.following(followeeId);
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User follower = userMap.get(followerId);
            follower.unfollowing(followeeId);
        }
    }
}

class User {
    int userId;
    List<Tweet> tweets;
    Set<Integer> followings;
    Set<Integer> followers;

    public User() {
        tweets = new LinkedList<>();
        followings = new HashSet<>();
        followers = new HashSet<>();
    }

    public User(int userId) {
        this.userId = userId;
        tweets = new LinkedList<>();
        followings = new HashSet<>();
        followers = new HashSet<>();
        followings.add(userId);
    }

    public void post(int tweetId) {
        Tweet tweet = new Tweet(tweetId, Twitter.timestamp++);
        tweets.add(0, tweet);
    }

    public void following(int followeeId) {
        followings.add(followeeId);
    }

    public void unfollowing(int followeeId) {
        if (followeeId != userId) {
            followings.remove(followeeId);
        }
    }

    public void followed(int followerId) {
        followers.add(followerId);
    }

    public void unfollowed(int followerId) {
        followings.remove(followerId);
    }

    public int getUserId() {
        return userId;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public Set<Integer> getFollowings() {
        return followings;
    }

    public Set<Integer> getFollowers() {
        return followers;
    }
}

class Tweet {
    int tweetId;
    int timestamp;

    public Tweet() {
    }

    public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }

    public int getTweetId() {
        return tweetId;
    }

    public int getTimestamp() {
        return timestamp;
    }
}