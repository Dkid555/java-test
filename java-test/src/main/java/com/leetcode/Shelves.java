package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Shelves {
    public static int solution(int[] A, int R) {
        // Implement your solution here
        int N = A.length;
        int maxTypes = 0;
        Set<Integer> keys = new HashSet<>();
        Map<Integer, Integer> typesCount = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            keys.add(A[i]);
            if (typesCount.getOrDefault(A[i], 0) == 0)
                typesCount.put(A[i], 1);
            else {
                if (R > 0)
                    R--;
//                else {
//                    typesCount.put(A[i], typesCount.getOrDefault(A[i], 0) + 1);
//                }
            }
        }
        if (R > 0) {
            for (int key : keys) {
                typesCount.remove(key);
            }
        }
        return typesCount.size();
    }

    public static int maxTypesAfterFreeingShelves(int[] A, int R) {
        int N = A.length;
        int maxTypes = 0;
        Map<Integer, Integer> typeCounts = new HashMap<>();

        // Count types on the first R shelves
        for (int i = 0; i < R; i++) {
            typeCounts.put(A[i], typeCounts.getOrDefault(A[i], 0) + 1);
        }

        maxTypes = typeCounts.size();

        // Slide the window and update type counts
        for (int i = R; i < N; i++) {
            int removedType = A[i - R];

            // Update type counts after freeing shelves
            typeCounts.put(removedType, typeCounts.get(removedType) - 1);
            if (typeCounts.get(removedType) == 0) {
                typeCounts.remove(removedType);
            }

            int addedType = A[i];
            typeCounts.put(addedType, typeCounts.getOrDefault(addedType, 0) + 1);

            // Update the maximum types after freeing shelves
            maxTypes = Math.max(maxTypes, typeCounts.size());
        }

        return maxTypes;
    }

    public static int solution2(int[] A, int R) {
        int start = 0;
        int end = R - 1;
        int size = A.length;
        int maxTypes = -1;
        while (end != size) {
            Set<Integer> types = new HashSet<>();
            for (int i = 0; i < A.length; ++i) {
                if (i == start) {
                    i = end;
                } else {
                    types.add(A[i]);
                }
            }
            start++;
            end++;
            maxTypes = Math.max(maxTypes, types.size());
        }
        return maxTypes;
    }

    public static int solution3(int[] A, int R) {
        if (R == A.length)
            return 0;
        int start = 0;
        int end = R - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = end + 1; i < A.length; ++i) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        ++end;
        ++start;
        int maxTypes = map.size();
        while (end != A.length) {
            map.put(A[end], map.get(A[end]) - 1);
            if (map.get(A[end]) == 0)
                map.remove(A[end]);
            map.put(A[start - 1], map.getOrDefault(A[start - 1], 0) + 1);
            maxTypes = Math.max(maxTypes, map.size());
            ++end;
            ++start;
        }
        return maxTypes;

    }

    public static void main(String[] args) {
        System.out.println(solution3(new int[]{2, 2, 2, 4}, 1));
    }
}
