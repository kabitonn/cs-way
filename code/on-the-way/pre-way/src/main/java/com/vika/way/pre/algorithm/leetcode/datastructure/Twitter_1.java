package com.vika.way.pre.algorithm.leetcode.datastructure;

import java.util.*;

/**
 * 355. 设计推特
 *
 * @author tokabi
 * @date 2019/10/29 22:19
 */
public class Twitter_1 {

    public static int timestamp = 1;
    public static int tweetNum = 10;

    private Map<Integer, List<Tweet>> tweetMap;
    private Map<Integer, Set<Integer>> followingMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter_1() {
        tweetMap = new HashMap<>();
        followingMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new LinkedList<>());
            follow(userId, userId);
        }
        tweetMap.get(userId).add(0, new Tweet(tweetId, timestamp++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!tweetMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(tweetNum + 1, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.timestamp - o2.timestamp;
            }
        });
        Set<Integer> followings = followingMap.get(userId);
        for (int id : followings) {
            List<Tweet> tweets = tweetMap.get(id);
            for (int i = 0; i < tweets.size() && i < tweetNum; i++) {
                minHeap.add(tweets.get(i));
                if (minHeap.size() > tweetNum) {
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
        if (!followingMap.containsKey(followerId)) {
            followingMap.put(followerId, new HashSet<>());
        }
        followingMap.get(followerId).add(followeeId);
        if (!tweetMap.containsKey(followerId)) {
            tweetMap.put(followerId, new LinkedList<>());
            follow(followerId, followerId);
        }
        if (!tweetMap.containsKey(followeeId)) {
            tweetMap.put(followeeId, new LinkedList<>());
            follow(followeeId, followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }
}
