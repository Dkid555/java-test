package com.leetcode;

import java.util.*;

public class DesignTwitter {
    private static class Twitter {
        private class User {
            int id;
            //            Set<Integer> followed;
            Set<Integer> follows;

            public User(int id) {
                this.id = id;
//                this.followed = new HashSet<>();
                this.follows = new HashSet<>();
            }
        }

        LinkedList<Map<User, Integer>> Twits;
        Map<Integer, User> Users;

        public Twitter() {
            this.Users = new HashMap<>();
            this.Twits = new LinkedList<>();
        }

        public void postTweet(int userId, int tweetId) {
//            User post =  this.Users.getOrDefault(userId, new User(userId));
            if (Users.containsKey(userId)) {
                this.Twits.add(Map.of(this.Users.get(userId), tweetId));
            } else {
                this.Users.put(userId, new User(userId));
                this.Twits.add(Map.of(this.Users.get(userId), tweetId));
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            if (Users.containsKey(userId)) {
                int count = 0;
                Set<Integer> currentUserFollows = this.Users.get(userId).follows;
                List<Integer> recent10Twits = new ArrayList<>();
                Iterator<Map<User, Integer>> it = this.Twits.descendingIterator();
                while (it.hasNext()) {
                    Map<User, Integer> current = it.next();
                    for (Map.Entry<User, Integer> entry : current.entrySet()) {
                        if (entry.getKey().id == userId) {
                            recent10Twits.add(entry.getValue());
                            ++count;
                            if (count == 10)
                                return recent10Twits;
                            break;
                        } else
                            for (Integer follow : currentUserFollows) {
                                if (entry.getKey().id == follow) {
                                    recent10Twits.add(entry.getValue());
                                    ++count;
                                    if (count == 10)
                                        return recent10Twits;
                                    break;
                                }
                            }
                    }
                }
                return recent10Twits;
            }
            return new ArrayList<>();
        }

        public void follow(int followerId, int followeeId) {
            if (!Users.containsKey(followerId)) {
                Users.put(followerId, new User(followerId));
            }
            if (!Users.containsKey(followeeId)) {
                Users.put(followeeId, new User(followeeId));
            }
            this.Users.get(followerId).follows.add(followeeId);
//            this.Users.get(followeeId).followed.add(followerId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!Users.containsKey(followerId)) {
                Users.put(followerId, new User(followerId));
            }
            if (!Users.containsKey(followeeId)) {
                Users.put(followeeId, new User(followeeId));
            }
            this.Users.get(followerId).follows.remove(followeeId);
//            this.Users.get(followeeId).followed.remove(followerId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);

        System.out.println(twitter.getNewsFeed(1));
    }
}
