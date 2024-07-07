package com.Amazon.Interval;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MeetingRooms {

    @NoArgsConstructor
    @AllArgsConstructor
    private static class Interval {
      int start;
      int end;
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a.start));
        Stack<Interval> stack = new Stack<>();
        for (Interval current : intervals){
            if(!stack.isEmpty()){
                Interval previous = stack.pop();
                if(previous.start == current.start || previous.end > current.start)
                    return false;
                else
                    stack.add(current);
            }else
                stack.add(current);
        }
        return true;
    }
}
//Given an array of meeting time intervals consisting of
// start and end times[[s1,e1],[s2,e2],...](si< ei), determine if a person could attend all meetings.