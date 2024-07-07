package com.Amazon.Interval;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

public class MeetingRoomsII {

    @NoArgsConstructor
    @AllArgsConstructor
    private static class Interval {
        int start;
        int end;
    }
//    @NoArgsConstructor
//    @AllArgsConstructor
//    private static class Point {
//        int time;
//        int type; // start: 1, end: 0
//    }
//
//    public static int minMeetingRooms(Interval[] intervals) {
//        List<Point> points = new ArrayList<>(intervals.length * 2);
//        for (Interval i : intervals) {
//            points.add(new Point(i.start, 1));
//            points.add(new Point(i.end, 0));
//        }
//        Comparator<Point> cmp = (a, b) -> {
//            if (a.time == b.time) {
//                return a.type - b.type;
//            } else {
//                return a.time - b.time;
//            }
//        };
//        points.sort(cmp);
//
//        int maxOverlap = 0;
//        int ongoing = 0;
//        for (Point p : points) {
//            if (p.type == 1) {
//                ongoing++;
//            } else if (p.type == 0) {
//                ongoing--;
//            }
//            maxOverlap = Math.max(maxOverlap, ongoing);
//        }
//
//        return maxOverlap;
//    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    private static class Room {
        private int time;
        private int type;
    }
    public static int minMeetingRooms(Interval[] intervals){

        List<Room> meetings = new ArrayList<>();

        for (Interval interval : intervals){
            meetings.add(new Room(interval.start, 1));
            meetings.add(new Room(interval.end, 0));
        }

        meetings.sort((a, b) -> {
            if (a.time == b.time) {
                return a.type - b.type;
            } else {
                return a.time - b.time;
            }
        });
        int overLap = 0;
        int busy_rooms = 0;
        for (Room room : meetings){
            if(room.type == 1)
                ++busy_rooms;
            else
                --busy_rooms;
            overLap = Math.max(overLap, busy_rooms);
        }
        return overLap;
    }
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new Interval[] {new Interval(0, 30),
                new Interval(5, 10), new Interval(15, 20)}));
    }
}
//Given an array of meeting time intervals consisting of start and
// end times[[s1,e1],[s2,e2],...](si< ei), find the minimum number of conference rooms required.