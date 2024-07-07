package Amazon;

import java.util.*;

public class FindAllPeopleWithSecret {
    public static int[][] convertToIntArray(String str) {
        // Remove the outer brackets
        str = str.substring(1, str.length() - 1);

        // Split into individual arrays
        String[] arrays = str.split("\\],\\[");

        // Create a list to store the arrays
        ArrayList<int[]> list = new ArrayList<>();

        for (String array : arrays) {
            // Remove any remaining brackets
            array = array.replaceAll("\\[|\\]", "");

            // Split into individual numbers
            String[] numbers = array.split(",");

            // Convert to int array
            int[] intArray = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intArray[i] = Integer.parseInt(numbers[i]);
            }

            // Add to list
            list.add(intArray);
        }

        // Convert list to 2D int array
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int n = 6;
        String meetups = "[[3,4,2],[1,2,1],[2,3,1]]";
        int[][] meetings = convertToIntArray(meetups); //new int[][]{{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson = 1;
        System.out.println(findAllPeople(n, meetings, firstPerson));
    }
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        Set<Integer> whoKnows = new HashSet<>();
        whoKnows.add(firstPerson);
        whoKnows.add(0);
        int i = 0;
        while (i < meetings.length){
            Map<Integer, List<Integer>> graph = new HashMap<>(); // build graph for current time meeting;

            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            int currentTime = meetings[i][2];

            while (i < meetings.length && meetings[i][2] == currentTime){
                graph.computeIfAbsent(meetings[i][0], k -> new ArrayList<>()).add(meetings[i][1]); // add to first person persons that he meets with
                graph.computeIfAbsent(meetings[i][1], k -> new ArrayList<>()).add(meetings[i][0]); // add to second person persons that he meets with
                ++i;
            }
            for (int person : graph.keySet()){
                if(whoKnows.contains(person)){
                    queue.add(person);
                    visited.add(person);
                }
            }

            while (!queue.isEmpty()){ // while queue of persons who knows at current time isn't empty
                int person = queue.poll(); // taking that person from queue
                List<Integer> neighbors = graph.get(person); // getting all his neighbors
                for (int neighbor : neighbors){ // iterate through them
                    if(!visited.contains(neighbor)){
                        queue.add(neighbor); // if we not have checked them yet adding them to visited and to queue for the next iteration
                        visited.add(neighbor);
                    }
                }
            }
            whoKnows.addAll(visited);
        }
        return new ArrayList<>(whoKnows);
    }
}

//   while (i < meetings.length) {
//            Map<Integer, List<Integer>> graph = new HashMap<>();
//            int currentTime = meetings[i][2];
//
//            while (i < meetings.length && meetings[i][2] == currentTime) {
//                graph.computeIfAbsent(meetings[i][0], k -> new ArrayList<>()).add(meetings[i][1]); /** parallel meetings of person1 */
//                graph.computeIfAbsent(meetings[i][1], k -> new ArrayList<>()).add(meetings[i][0]); /** parallel meetings of person2 */
//                ++i;
//            }
//
//            Queue<Integer> queue = new LinkedList<>();
//            Set<Integer> visited = new HashSet<>();
//
//            for (int person : graph.keySet()) {
//                if (whoKnows.contains(person)) {
//                    queue.offer(person);
//                    visited.add(person);
//                }
//            }
//
//            while (!queue.isEmpty()) {
//                int person = queue.poll();
//                for (int neighbor : graph.get(person)) {
//                    if (!visited.contains(neighbor)) {
//                        visited.add(neighbor);
//                        queue.offer(neighbor);
//                    }
//                }
//            }
//            whoKnows.addAll(visited);
//        }
//
//        return new ArrayList<>(whoKnows);

/**
 * You are given an integer n indicating there are n people numbered from 0 to n - 1.
 * You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei]
 * indicates that person xi and person yi have a meeting at timei.
 * A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
 *
 * Person 0 has a secret and initially shares the secret with a person firstPerson at time 0.
 * This secret is then shared every time a meeting takes place with a person that has the secret.
 * More formally, for every meeting, if a person xi has the secret at timei,
 * then they will share the secret with person yi, and vice versa.
 *
 * The secrets are shared instantaneously. That is,
 * a person may receive the secret and share it with people in other meetings within the same time frame.
 *
 * Return a list of all the people that have the secret after all
 * the meetings have taken place. You may return the answer in any order.
 * */
