package com.Amazon.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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

    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][]{{1, 0}, {0, 2}}));
    }
}
//There are a total of numCourses courses you have to take,
// labeled from 0 to numCourses - 1. You are given an array prerequisites
// where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

//Создается список смежности adj, где каждый узел представляет курс, а его дочерние узлы - это курсы, которые должны быть взяты до этого курса.
//Создается массив preReqRequired, чтобы отслеживать количество предварительных курсов, необходимых для каждого курса.
//Проходим по массиву предварительных курсов prerequisites, заполняя списки смежности и обновляя массив preReqRequired.
//Создается очередь queue и добавляются все курсы, для которых не требуется никаких предварительных курсов (их preReqRequired равно 0).
//Создается список topoOrder для хранения топологического порядка прохождения курсов.
//В цикле while извлекаем курсы из очереди, добавляем их в topoOrder и уменьшаем количество предварительных курсов для всех их дочерних курсов. Если для какого-то дочернего курса количество его предварительных курсов становится равным 0, добавляем его в очередь.
//Возвращаем true, если размер списка topoOrder равен общему количеству курсов, иначе возвращаем false.