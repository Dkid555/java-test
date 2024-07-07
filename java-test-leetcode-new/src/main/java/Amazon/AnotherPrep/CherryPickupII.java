package Amazon.AnotherPrep;

public class CherryPickupII {//
    public static void main(String[] args) {
        System.out.println(cherryPickup(
                new int[][]
                                {
                                        {3,1,1},
                                        {2,5,1},
                                        {1,5,5},
                                        {2,1,1},
                                }
        ));
    }

    static int[][] robotMoves = {
            {+1, -1},
            {+1, 0},
            {+1, +1},
    };

    public static int cherryPickup(int[][] grid) {
//        Map<String, Integer> memo = new HashMap<>();
        Integer[][][] memo = new Integer[grid.length][grid[0].length][grid[0].length];
        return dfs(new int[]{0, 0}, new int[]{0, grid[0].length - 1}, grid, memo);
    }

    private static int dfs(int[] robot1, int[] robot2, int[][] grid, /*Map<String, Integer> memo*/ Integer[][][] memo) {
        int robot1_x = robot1[0], robot1_y = robot1[1];
        int robot2_x = robot2[0], robot2_y = robot2[1];

        if (robot1_x >= grid.length || robot1_y < 0 || robot1_y >= grid[0].length ||
                robot2_x >= grid.length || robot2_y < 0 || robot2_y >= grid[0].length) {
            return 0;
        }

//        String key = robot1_x + "," + robot1_y + "," + robot2_y; // robot1_x === robot2_x
        if(memo[robot1_x][robot1_y][robot2_y] != null)
            return memo[robot1_x][robot1_y][robot2_y];
//        if (memo.containsKey(key)) {
//            return memo.get(key);
//        }

        int cherries = (robot1_y == robot2_y) ? grid[robot1_x][robot1_y] : grid[robot1_x][robot1_y] + grid[robot2_x][robot2_y];

        int maxCherries = 0;
        for (int[] move_robot1 : robotMoves) {
            int[] newRobot1 = {robot1_x + move_robot1[0], robot1_y + move_robot1[1]};
            for (int[] move_robot2 : robotMoves) {
                int[] newRobot2 = {robot2_x + move_robot2[0], robot2_y + move_robot2[1]};
                maxCherries = Math.max(maxCherries, dfs(newRobot1, newRobot2, grid, memo));
            }
        }

        cherries += maxCherries;
        memo[robot1_x][robot1_y][robot2_y] = cherries;
//        memo.put(key, cherries);
        return cherries;
    }
    /**
     You are given a rows x cols matrix grid representing a field of
     cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

     You have two robots that can collect cherries for you:

     Robot #1 is located at the top-left corner (0, 0), and
     Robot #2 is located at the top-right corner (0, cols - 1).
     Return the maximum number of cherries collection using both robots by following the rules below:

     From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
     When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
     When both robots stay in the same cell, only one takes the cherries.
     Both robots cannot move outside of the grid at any moment.
     Both robots should reach the bottom row in grid.
     * */

//    static int[][] robotMoves = {
//            {+1, -1},
//            {+1, 0},
//            {+1, +1},
//    };
//
//
//    public static int cherryPickup(int[][] grid) {
//        int[] robot_1_start = {0, 0};
//        int[] robot_2_start = {0, grid[0].length - 1};
//        int[] maxCherries = {0};
//        Map<String, Integer> memo = new HashMap<>();
//        dfs (robot_1_start, robot_2_start, grid, maxCherries, ( Arrays.compare(robot_1_start, robot_2_start) == 0
//                ? grid[robot_1_start[0]][robot_1_start[1]] :
//                grid[robot_1_start[0]][robot_1_start[1]] +
//                        grid[robot_2_start[0]][robot_2_start[1]]
//        ), memo);
//
//        return maxCherries[0];
//
//    }
//    private static void dfs(int[] robot_1_start, int[] robot_2_start, int[][] grid ,int[] maxCherries, int currentMax, Map<String, Integer> memo){
//        if(     robot_1_start[0] >= grid.length ||
//                robot_1_start[0] < 0 ||
//                robot_1_start[1] >= grid[0].length ||
//                robot_1_start[1] < 0||
//                robot_2_start[0] >= grid.length ||
//                robot_2_start[0] < 0 ||
//                robot_2_start[1] >= grid[0].length ||
//                robot_2_start[1] < 0
//        ){
//            maxCherries[0] = Math.max(maxCherries[0], currentMax);
//            return;
//        }
//        if(memo.containsKey("" + robot_1_start[0]*100 + robot_1_start[1] +  robot_2_start[0] * 100  + robot_2_start[1])){
//            maxCherries[0] = Math.max(maxCherries[0], currentMax + memo.get("" + robot_1_start[0]*100 + robot_1_start[1] +  robot_2_start[0] * 100  + robot_2_start[1]));
//            return;
//        }
//
//        for(int[] robot1_move : robotMoves){
//            int[] robot_1_new_coordinates = {
//                    robot_1_start[0] + robot1_move[0],
//                    robot_1_start[1] + robot1_move[1]
//            };
//            for(int[] robot2_move : robotMoves){
//                int[] robot_2_new_coordinates = {
//                        robot_2_start[0] + robot2_move[0],
//                        robot_2_start[1] + robot2_move[1]
//                };
//                dfs(
//                        robot_1_new_coordinates,
//                        robot_2_new_coordinates,
//                        grid,
//                        maxCherries,
//                        currentMax +
//                                ( Arrays.compare(robot_1_new_coordinates, robot_2_new_coordinates) == 0
//                            ? ((
//                                                    robot_1_new_coordinates[0] >= grid.length ||
//                                                    robot_1_new_coordinates[0] < 0 ||
//                                                    robot_1_new_coordinates[1] >= grid[0].length ||
//                                                    robot_1_new_coordinates[1] < 0
//
//                                        ) ? 0 : grid[robot_1_new_coordinates[0]][robot_1_new_coordinates[1]] ):
//
//                                        ((      robot_1_new_coordinates[0] >= grid.length ||
//                                                robot_1_new_coordinates[0] < 0 ||
//                                                robot_1_new_coordinates[1] >= grid[0].length ||
//                                                robot_1_new_coordinates[1] < 0
//                                        ) ? 0 : grid[robot_1_new_coordinates[0]][robot_1_new_coordinates[1]] ) +
//                                                ((
//                                                                robot_2_new_coordinates[0] >= grid.length ||
//                                                                robot_2_new_coordinates[0] < 0 ||
//                                                                robot_2_new_coordinates[1] >= grid[0].length ||
//                                                                robot_2_new_coordinates[1] < 0
//                                                        ) ? 0 : grid[robot_2_new_coordinates[0]][robot_2_new_coordinates[1]] )
//                                ),
//                        memo
//                );
//            }
//        }



}
