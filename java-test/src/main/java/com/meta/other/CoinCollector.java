package com.meta.other;

import java.util.*;

public class CoinCollector {

    static void dfs(Graph<Room> graph, Room room, Set<Room> visited, int count, Stack<Integer> max, Stack<Integer> max_current, Map<Room, Integer> max_for_room) {
        if (!visited.contains(room)) {

            if (max_for_room.containsKey(room)) {
                max.add(max.pop() + max_for_room.get(room));
                max_current.add(max_current.pop() + max_for_room.get(room));
                return;
            }

            max.add(Math.max(max.pop(), count));
            max_current.add(Math.max(max_current.pop(), count));
            visited.add(room);
            Set<Room> neighboors = graph.getNeighbors(room);
            for (Room neighboor : neighboors) {
                dfs(graph, neighboor, visited, count + neighboor.coins_amount, max, max_current, max_for_room);
                visited.remove(neighboor);
            }
        }
    }

    public static int calcucateMaxCoins(int[] Coins_per_room, int[][] tunnels) {
        Graph<Room> graph = new Graph<>();
        Map<Integer, Room> Rooms = new HashMap<>();
        for (int i = 1; i <= Coins_per_room.length; ++i) {
            Rooms.put(i, new Room(Coins_per_room[i - 1], i));
            graph.addVertex(Rooms.get(i));
        }
        for (int[] tunnel : tunnels) {
            graph.addEdge(Rooms.get(tunnel[0]), Rooms.get(tunnel[1]));
        }
        Map<Room, Integer> max_for_room = new HashMap<>();
        Stack<Integer> max = new Stack<>();
        max.add(Integer.MIN_VALUE);
        for (Map.Entry<Integer, Room> entry : Rooms.entrySet()) {
            Room room = entry.getValue();
            Stack<Integer> max_current = new Stack<>();
            max_current.add(Integer.MIN_VALUE);
            dfs(graph, room, new HashSet<>(), room.coins_amount, max, max_current, max_for_room);
        }

        return max.pop();
    }

    public static void main(String[] args) {
        System.out.println(calcucateMaxCoins(new int[]{4, 5, 2, 7}, new int[][]{{1, 2}, {2, 1}, {1, 3}, {2, 4}}));
    }

    private static class Room {
        private int coins_amount;
        private Integer room;

        public Room(int coins_amount, int room) {
            this.coins_amount = coins_amount;
            this.room = room;
        }


        public int getCoins_amount() {
            return coins_amount;
        }

        public void setCoins_amount(int coins_amount) {
            this.coins_amount = coins_amount;
        }

        public int getRoom() {
            return room;
        }

        public void setRoom(int room) {
            this.room = room;
        }

        public int hashCode() {
            return this.room.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Room)) {
                return false;
            }
            Room another = (Room) obj;

            return this.room == another.room;
        }
    }

    private static class Graph<T> {
        private Map<T, Set<T>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        public void addVertex(T vertex) {
            adjacencyList.put(vertex, new HashSet<>());
        }

        public Set<T> getAllVertexes() {
            return adjacencyList.keySet();
        }

        public boolean containsVertex(T vertex) {
            return adjacencyList.containsKey(vertex);
        }

        public void addEdge(T source, T destination) {
            if (!adjacencyList.containsKey(source)) {
                addVertex(source);
            }
            if (!adjacencyList.containsKey(destination)) {
                addVertex(destination);
            }
            adjacencyList.get(source).add(destination);
        }

        public Set<T> getNeighbors(T vertex) {
            return adjacencyList.get(vertex);
        }
    }
}
//A game has n rooms and m tunnels between them. Each room has a certain number of coins.
// What is the maximum number of coins you can collect while moving through the
// tunnels when you can freely choose your starting and ending room?
