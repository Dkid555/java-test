package com.Amazon;

import java.util.*;

public class MinimumNumberofArrowstoBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{1, 2}, {1, 1}, {1, 4}};
        int[][] points2 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points2));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        long arrow_shot = -2147483649L;
        int arrow_count = 0;
        for (int[] point : points) {
            if (arrow_shot >= point[0] && arrow_shot <= point[1]) {
                continue;
            }
            arrow_shot = point[1];
            arrow_count++;
        }
        return arrow_count;
    }

    private static class Balloon {

        public int getBalloon() {
            return balloon;
        }

        public void setBalloon(int balloon) {
            this.balloon = balloon;
        }

        public Balloon(int balloon) {
            this.balloon = balloon;
        }

        int balloon;
    }

    public static int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, (int[] o1, int[] o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1]; // Compare second elements if first elements are equal
            } else {
                return o1[0] - o2[0]; // Compare first elements otherwise
            }
        });
//        List<List<Integer>> list = new ArrayList<>();

        Map<Integer, Set<Balloon>> arrows_possible_to_shoot = new HashMap<>();

        Map<Integer, Balloon> balloons = new HashMap<>();
        int balloon = 1;
        for (int[] point : points) {
            for (int i = point[0]; i <= point[1]; ++i) {
                arrows_possible_to_shoot.putIfAbsent(i, new HashSet<>());
                Balloon balloon1 = balloons.getOrDefault(balloon, new Balloon(balloon));
                balloons.putIfAbsent(balloon, balloon1);
                arrows_possible_to_shoot.get(i).add(balloon1);
            }
            ++balloon;
        }
        int arrows = 0;
        while (true) {
            List<Map.Entry<Integer, Set<Balloon>>> list_map = new ArrayList<>(arrows_possible_to_shoot.entrySet());
            list_map.sort(Comparator.comparing(list_m -> list_m.getValue().size()));

            Set<Balloon> most_balloons = list_map.get(list_map.size() - 1).getValue();
            if (most_balloons.isEmpty())
                break;
            else {
                ++arrows;
                for (Balloon b : Set.copyOf(most_balloons)) {
                    for (Set<Balloon> set_balloon : arrows_possible_to_shoot.values()) {
                        set_balloon.remove(b);
                    }
                }
            }
        }
        return arrows;
    }
}
//There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
//
//Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
//
//Given the array points, return the minimum number of arrows that must be shot to burst all balloons.