package com.Amazon;

import java.util.*;

public class ProcessTasksUsingServers {

    public static void main(String[] args) {
        int[] servers = {338, 890, 301, 532, 284, 930, 426, 616, 919, 267, 571, 140, 716, 859, 980, 469, 628,
                490, 195, 664, 925, 652, 503, 301, 917, 563, 82, 947, 910, 451, 366, 190, 253, 516, 503, 721, 889,
                964, 506, 914, 986, 718, 520, 328, 341, 765, 922, 139, 911, 578, 86, 435, 824, 321, 942, 215, 147, 985, 619, 865};
        int[] tasks = {773, 537, 46, 317, 233, 34, 712, 625, 336, 221, 145, 227, 194, 693, 981, 861, 317, 308, 400, 2,
                391, 12, 626, 265, 710, 792, 620, 416, 267, 611, 875, 361, 494, 128, 133, 157, 638, 632, 2, 158, 428, 284,
                847, 431, 94, 782, 888, 44, 117, 489, 222, 932, 494, 948, 405, 44, 185, 587, 738, 164, 356, 783, 276, 547,
                605, 609, 930, 847, 39, 579, 768, 59, 976, 790, 612, 196, 865, 149, 975, 28, 653, 417, 539, 131, 220, 325,
                252, 160, 761, 226, 629, 317, 185, 42, 713, 142, 130, 695, 944, 40, 700, 122, 992, 33, 30, 136, 773, 124, 203,
                384, 910, 214, 536, 767, 859, 478, 96, 172, 398, 146, 713, 80, 235, 176, 876, 983, 363, 646, 166, 928, 232, 699,
                504, 612, 918, 406, 42, 931, 647, 795, 139, 933, 746, 51, 63, 359, 303, 752, 799, 836, 50, 854, 161, 87, 346, 507,
                468, 651, 32, 717, 279, 139, 851, 178, 934, 233, 876, 797, 701, 505, 878, 731, 468, 884, 87, 921, 782, 788, 803,
                994, 67, 905, 309, 2, 85, 200, 368, 672, 995, 128, 734, 157, 157, 814, 327, 31, 556, 394, 47, 53, 755, 721, 159, 843};
        System.out.println(Arrays.toString(assignTasks(servers, tasks)));
    }

    private static class Server2 {
        public Server2(int ID, int weight, boolean status, int time_stamp) {
            this.ID = ID;
            this.weight = weight;
            this.status = status;
            this.time_stamp = time_stamp;
        }

        private final int ID;
        private final int weight;
        private boolean status; // true - свободен  false -busy
        private int time_stamp;
    }

    public static int[] assignTasks2(int[] servers, int[] tasks) {
//        Arrays.sort(servers);
        int[] answer = new int[tasks.length];
        List<Server2> servers_ = new ArrayList<>();
        for (int ID = 0; ID < servers.length; ++ID) {
            servers_.add(new Server2(ID, servers[ID], true, 0));
        }
        servers_.sort((a, b) -> {
            if (a.weight == b.weight)
                return a.ID - b.ID;
            return a.weight - b.weight;
        });

        for (int i = 0; i < tasks.length; ++i) {
            int task_time = tasks[i];
            boolean assigned = false;

            for (Server2 server : servers_) {
                if (!server.status) {
                    --server.time_stamp;
                    if (server.time_stamp == 0)
                        server.status = true;
                }
                if (!assigned) {
                    if (server.status) {
                        assigned = true;
                        server.status = false;
                        server.time_stamp = task_time;
                        answer[i] = server.ID;
                    }
                }
            }
            if (!assigned)
                --i;
        }
        return answer;
    }


    private static class Server {
        int weight;
        int index;
        int finishTime;

        Server(int w, int i, int ft) {
            this.weight = w;
            this.index = i;
            this.finishTime = ft;
        }
    }

    public static int[] assignTasks(int[] servers, int[] tasks) {
        Comparator<Server> cmp1 = (s1, s2) -> {
            if (s1.weight == s2.weight) {
                return s1.index - s2.index;
            } else {
                return s1.weight - s2.weight;
            }
        };
        Comparator<Server> cmp2 = (s1, s2) -> {
            if (s1.finishTime == s2.finishTime) {
                if (s1.weight == s2.weight) {
                    return s1.index - s2.index;
                } else {
                    return s1.weight - s2.weight;
                }
            } else {
                return s1.finishTime - s2.finishTime;
            }
        };
        PriorityQueue<Server> freeServers = new PriorityQueue<>(cmp1);
        for (int i = 0; i < servers.length; i++) {
            Server s = new Server(servers[i], i, Integer.MIN_VALUE);
            freeServers.offer(s);
        }
        PriorityQueue<Server> busyServers = new PriorityQueue<>(cmp2);
        int[] ans = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            //move servers that are now idle from busy servers to free servers
            int curTime = i;
            while (!busyServers.isEmpty() && busyServers.peek().finishTime == curTime) {
                freeServers.offer(busyServers.poll());
            }
            Server current_Server;
            if (freeServers.isEmpty()) {
                current_Server = busyServers.poll();
                current_Server.finishTime = current_Server.finishTime + tasks[i];
                ans[i] = current_Server.index;
            } else {
                current_Server = freeServers.poll();
                ans[i] = current_Server.index;
                current_Server.finishTime = curTime + tasks[i];
            }
            busyServers.offer(current_Server);

        }
        return ans;
    }

}
//You are given two 0-indexed integer arrays servers and tasks of lengths
// n and m respectively. servers[i]
// is the weight of the i server, and tasks[j]
// is the time needed to process the j task in seconds.
//
//Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the queue is empty.
//
//At second j, the jth task is inserted into the queue (starting with the 0th task being
// inserted at second 0). As long as there are free servers and the queue is not empty,
// the task in the front of the queue will be assigned to a free server with the smallest
// weight, and in case of a tie, it is assigned to a free server with the smallest index.
//
//If there are no free servers and the queue is not empty, we wait until a server becomes
// free and immediately assign the next task. If multiple servers become free at the same time,
// then multiple tasks from the queue will be assigned in
// order of insertion following the weight and index priorities above.
//
//A server that is assigned task j at second t will be free again at second t + tasks[j].
//
//Build an array ans of length m, where ans[j] is the index of
// the server the j task will be assigned to.
//
//Return the array ans.