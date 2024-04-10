package com.meta.other;

import java.util.*;

public class CourseScheduleII {
    private static class Course {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Course course1)) return false;
            return course == course1.course;
        }

        @Override
        public int hashCode() {
            return Objects.hash(course);
        }

        int course;
        Set<Course> next;

        public Course(int course) {
            this.course = course;
            this.next = new HashSet<>();
        }

        public void addNext(Course course) {
            this.next.add(course);
        }

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Course> courseMap = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            courseMap.put(i, new Course(i));
        }

        // linkin courses
        for (int[] prereq : prerequisites) {
            courseMap.get(prereq[1]).next.add(courseMap.get(prereq[0]));
        }
        List<Course> result = new ArrayList<>();
        bfs(courseMap, 0, result);

        return new int[2];
    }

    public static void bfs(Map<Integer, Course> courseMap, int course, List<Course> result) {
        Set<Course> visited = new HashSet<>();
        Queue<Course> queue = new ArrayDeque<>();
        queue.offer(courseMap.get(course));
        while (!queue.isEmpty()) {
            Course vertex = queue.poll();
            if (!visited.contains(vertex)) {
                result.add(vertex);
                visited.add(vertex);
//                Collections.addAll(queue, graph.getNeighbors(vertex));
                queue.addAll(vertex.next);
            }
        }

    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder2(4, prerequisites)));

    }

    static ArrayList<Integer>[] graph;


    static void addEdge(int a, int b) {
        graph[b].add(a);
    }


    public static int[] findOrder2(int num, int[][] pre) {

        int edges = pre.length;
        graph = new ArrayList[num];

        for (int i = 0; i < num; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < pre.length; i++) {
            addEdge(pre[i][0], pre[i][1]);
        }

        int[] indegree = new int[num];

        for (int i = 0; i < pre.length; i++) {
            indegree[pre[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        if (q.size() == 0) {
            int[] arr = {};
            return arr;
        }
        int[] ans = new int[num];
        int idx = 0;

        while (q.size() != 0) {
            int a = q.remove();
            ans[idx++] = a;
            for (var x : graph[a]) {
                indegree[x]--;
                if (indegree[x] == 0) q.add(x);
            }
        }
        if (idx != num) {
            int[] arr = {};
            return arr;
        } else return ans;

    }

}
