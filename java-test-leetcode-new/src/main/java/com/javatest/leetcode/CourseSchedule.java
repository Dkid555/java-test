package com.javatest.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    private static class CourseConn {
        public void setCourse(int course) {
            this.course = course;
        }

        public void setNexts(Set<Integer> nexts) {
            this.nexts = nexts;
        }

        public int getCourse() {
            return course;
        }

        public Set<Integer> getNexts() {
            return nexts;
        }

        private int course;
        private Set<Integer> nexts;

        public CourseConn(int course) {
            this.course = course;
            this.nexts = new HashSet<Integer>();
        }
    }

    public static void canFinish(int numCourses, int[][] prerequisites) {
        Set<CourseConn> courses = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new CourseConn(i));
        }
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int count = 0;
        for (int[] requisite : prerequisites) {
            Set<Integer> temp = map.getOrDefault(requisite[0], new HashSet<>());
            temp.add(requisite[1]);
            map.put(requisite[0], temp);
            if (map.containsKey(requisite[1])) {
                if (map.get(requisite[1]).contains(requisite[0])) count++;
            }
        }
        if (count == 0) return true;
        return numCourses <= prerequisites.length - count;
    }


    public static void main(String[] args) {
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
//        canFinish(5, prerequisites);
        System.out.println(canFinish2(5, prerequisites));
    }
}
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
// must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.


//

