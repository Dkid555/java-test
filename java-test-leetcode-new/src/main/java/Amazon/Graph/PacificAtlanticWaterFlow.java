package com.Amazon.Graph;

import lombok.*;

import java.util.*;

public class PacificAtlanticWaterFlow {


//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Getter
//    @Setter
//    @EqualsAndHashCode
//    private static class Point{
//        private int height;
//        private int row;
//        private int column;
//        private boolean[] oceans; // 0 - Pacific (left + top), 1 - Atlantic (right + bottom)
//        Set<Point> next_points;
//    }
    private static class Point{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return getHeight() == point.getHeight() && getRow() == point.getRow() && getColumn() == point.getColumn() && Arrays.equals(getOceans(), point.getOceans()) && Objects.equals(getNext_points(), point.getNext_points());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getHeight(), getRow(), getColumn(), getNext_points());
        result = 31 * result + Arrays.hashCode(getOceans());
        return result;
    }

    private int height;
    private int row;
    private int column;
    private boolean[] oceans; // 0 - Pacific (left + top), 1 - Atlantic (right + bottom)
    Set<Point> next_points;

    public Point(int height, int row, int column, boolean[] oceans, Set<Point> next_points) {
        this.height = height;
        this.row = row;
        this.column = column;
        this.oceans = oceans;
        this.next_points = next_points;
    }



    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean[] getOceans() {
        return oceans;
    }

    public void setOceans(boolean[] oceans) {
        this.oceans = oceans;
    }

    public Set<Point> getNext_points() {
        return next_points;
    }

    public void setNext_points(Set<Point> next_points) {
        this.next_points = next_points;
    }
}


    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] moves = new int[][] {{0, 1}, {0,-1}, {1, 0}, {-1, 0}/*, {1, 1}, {-1, 1}, {1, -1}, {-1, -1} */};
        Map<String, Point> mapOfPoints = new HashMap<>();
        Set<Point>result = new HashSet<>();
        for(int row = 0; row < heights.length; ++row){
            for (int column = 0; column < heights[row].length; ++column){
                int height = heights[row][column];
                boolean pacific = false;
                boolean atlantic = false;
                if(row == 0 || column == 0){
                    pacific = true;
                }
                if(row == heights.length - 1 || column == heights[row].length - 1)
                    atlantic = true;
                Point point = new Point(height, row, column, new boolean[]{pacific, atlantic}, new HashSet<>());
                if(!atlantic && !pacific){
                    for(int[] direction: moves){
                        if(mapOfPoints.containsKey("R"+(row + direction[0])+"C"+(column + direction[1]))){
                            Point prevPoint = mapOfPoints.get("R"+(row + direction[0])+"C"+(column + direction[1]));
                            if(prevPoint.getHeight() <= height){
                                boolean[] prev_oceans = prevPoint.getOceans();
                                point.getOceans()[0] = point.getOceans()[0] || prev_oceans[0];
                                point.getOceans()[1] = point.getOceans()[1] || prev_oceans[1];
                            }
                        }
                    }
                }
                if(point.getOceans()[0] && point.getOceans()[1]){
                    result.add(point);
                }
                mapOfPoints.put("R"+row+"C"+column, point);
            }
        }
        for(int row = heights.length - 1; row >= 0; --row){
            for (int column = heights[row].length - 1; column >= 0; --column){
                Point point = mapOfPoints.get("R"+row+"C"+column);
                int height = heights[row][column];
                for(int[] direction: moves){
                    if(mapOfPoints.containsKey("R"+(row + direction[0])+"C"+(column + direction[1]))){
                        Point prevPoint = mapOfPoints.get("R"+(row + direction[0])+"C"+(column + direction[1]));
                        if(prevPoint.getHeight() <= height){
                            boolean[] prev_oceans = prevPoint.getOceans();
                            point.getOceans()[0] = point.getOceans()[0] || prev_oceans[0];
                            point.getOceans()[1] = point.getOceans()[1] || prev_oceans[1];
                        }
                    }
                }
                if(point.getOceans()[0] && point.getOceans()[1]){
                    result.add(point);
                }
                mapOfPoints.put("R"+row+"C"+column, point);
            }
        }
        return result.stream().map(point -> List.of(point.row, point.column)).toList();
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }




    static class Cell {
        public int X;
        public int Y;

        Cell(Integer x, Integer y){
            X = x;
            Y = y;
        }
    }

    static class Status {
        public boolean visitedAtlantic = false;
        public boolean visitedPacific = false;
    }

    private static class Solution {

        private int rows;
        private int columns;

        private List<Cell> calculateNextCells(Cell currentCell,int[][] heights,HashSet<List<Integer>> set){
            List<Cell> nextCells = new ArrayList<>();

            int currentHeight = heights[currentCell.X][currentCell.Y];

//      Go Bottom
            if(currentCell.X+1<rows && heights[currentCell.X+1][currentCell.Y] <= currentHeight){
                List<Integer> nextB = new ArrayList<>();
                nextB.add(currentCell.X+1);
                nextB.add(currentCell.Y);
                if(!set.contains(nextB)) {
                    nextCells.add(new Cell(currentCell.X + 1, currentCell.Y));
                }
            }


//      Go Top
            if(currentCell.X-1>=0 && heights[currentCell.X-1][currentCell.Y] <= currentHeight){
                List<Integer> nextT = new ArrayList<>();
                nextT.add(currentCell.X-1);
                nextT.add(currentCell.Y);
                if(!set.contains(nextT)) {
                    nextCells.add(new Cell(currentCell.X - 1, currentCell.Y));
                }
            }

//      Go Left
            if(currentCell.Y-1>=0 && heights[currentCell.X][currentCell.Y-1] <= currentHeight){
                List<Integer> nextL = new ArrayList<>();
                nextL.add(currentCell.X);
                nextL.add(currentCell.Y-1);
                if(!set.contains(nextL)) {
                    nextCells.add(new Cell(currentCell.X, currentCell.Y-1));
                }
            }

//      Go Right
            if(currentCell.Y+1<columns && heights[currentCell.X][currentCell.Y+1] <= currentHeight){
                List<Integer> nextR = new ArrayList<>();
                nextR.add(currentCell.X);
                nextR.add(currentCell.Y+1);
                if(!set.contains(nextR)) {
                    nextCells.add(new Cell(currentCell.X, currentCell.Y+1));
                }
            }

            return nextCells;
        }

        private Status checkForWaterFlow(Cell cell,Status status){

//      Check For Pacific Ocean ( Top Row & Left Row )
            if((cell.X == 0) && (cell.Y>=0 && cell.Y<columns)){
                status.visitedPacific = true;
            }

            if((cell.Y == 0) && (cell.X>= 0 && cell.X < rows)){
                status.visitedPacific = true;
            }

//      Check In Atlantic Ocean ( Bottom Row & Right Row )
            if((cell.X == rows-1) && (cell.Y>=0 && cell.Y<columns)){
                status.visitedAtlantic = true;
            }

            if((cell.Y == columns-1) && (cell.X>=0 && cell.X < rows)){
                status.visitedAtlantic = true;
            }

            return status;
        }

        private boolean depthFirstSearch(int[][] heights,Cell cell,Status status,HashSet<List<Integer>> set){

            List<Integer> nextB = new ArrayList<>();
            nextB.add(cell.X);
            nextB.add(cell.Y);

            set.add(nextB);

            List<Cell> nextCells = calculateNextCells(cell,heights,set);
            Status newStatus = checkForWaterFlow(cell,status);

            if(nextCells.size()==0){
//          If this is true, then add cell to result
                return (newStatus.visitedAtlantic && newStatus.visitedPacific);
            }

            for(Cell nextCell : nextCells){
                if(depthFirstSearch(heights,nextCell,newStatus,set)){
                    return true;
                }
            }

            return false;
        }

        public List<List<Integer>> pacificAtlantic(int[][] heights) {

            rows = heights.length;
            columns = heights[0].length;
            List<List<Integer>> result = new ArrayList<>();

            for(int i=0;i<heights.length;i++){
                for(int j=0;j<heights[i].length;j++){
                    Cell cell = new Cell(i,j);
                    Status status = new Status();
                    HashSet<List<Integer>> set  = new HashSet<>();
                    if(depthFirstSearch(heights,cell,status,set)){
                        List<Integer> res = new ArrayList<>();
                        res.add(i);
                        res.add(j);
                        result.add(res);
                    }
                }
            }

            return result;
        }
    }


}
//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
// The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches
// the island's right and bottom edges.
//
//The island is partitioned into a grid of square cells.
// You are given an m x n integer matrix heights where heights[r][c]
// represents the height above sea level of the cell at coordinate (r, c).
//
//The island receives a lot of rain, and the rain water can flow to neighboring
// cells directly north, south, east, and west if the neighboring cell's height
// is less than or equal to the current cell's height. Water can flow from any
// cell adjacent to an ocean into the ocean.
//
//Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes
// that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.