package com.leetcode;

public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;

        int prevIndex = -1;

        int minDist = Integer.MAX_VALUE;

        int firstIndex = -1;

        int index = 0;

        while (next != null) {
            if (prev != null) {
                if ((prev.val < current.val && next.val < current.val) || (prev.val > current.val && next.val > current.val)) {
                    if (prevIndex != -1) {
                        minDist = Math.min(minDist, index - prevIndex);
                    } else {
                        firstIndex = index;
                    }
                    prevIndex = index;
                }
            }
            index++;
            prev = current;
            current = current.next;
            next = next.next;
        }

        if (prevIndex == -1 || firstIndex == prevIndex) {
            return new int[]{-1, -1};
        }

        int maxDist = prevIndex - firstIndex;

        return new int[]{minDist, maxDist};
    }
}
