package com.javatest.leetcode;

import java.util.*;

public class CourseSchedule2 {


    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] preReqRequired = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int preReq = prerequisite[1];
            adj.get(preReq).add(prerequisite[0]);
            preReqRequired[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preReqRequired[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);
            for (int i = 0; i < adj.get(curr).size(); i++) {
                preReqRequired[adj.get(curr).get(i)]--;
                if (preReqRequired[adj.get(curr).get(i)] == 0) {
                    queue.add(adj.get(curr).get(i));
                }
            }
        }
        return topoOrder.size() == numCourses;
    }


    private static class Course {
        int courseNum;
        Set<Integer> set_of_courses;

        public Course(int courseNum, Set<Integer> set_of_courses) {
            this.courseNum = courseNum;
            this.set_of_courses = set_of_courses;
        }
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<ListNode, Set<ListNode>> map = new HashMap<>();
        Map<Integer, ListNode> exists = new HashMap<>();
        for (int[] prereq : prerequisites) {

            ListNode course = exists.getOrDefault(prereq[1], new ListNode(prereq[1]));

            exists.put(prereq[1], course);


            Set<ListNode> set = map.getOrDefault(course, new HashSet<>());

            ListNode next_course = exists.getOrDefault(prereq[0], new ListNode(prereq[0]));
            exists.put(prereq[0], next_course);

            set.add(next_course);

            map.put(course, set);
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
//        canFinish(5, prerequisites);
        System.out.println(canFinish(5, prerequisites));
    }

}
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
// take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

//Общее количество numCoursesкурсов, которые вам необходимо пройти, отмечено от 0до numCourses - 1.
// Вам дан массив prerequisites, где указано, что вы должны сначала пройти курс , если хотите пройти курс .prerequisites[i] = [ai, bi]biai
//
//Например, пара [0, 1]указывает, что для того, чтобы пройти курс, 0вам нужно сначала пройти курс 1.
//Возвращайтесь true, если сможете закончить все курсы. В противном случае вернитесь false.