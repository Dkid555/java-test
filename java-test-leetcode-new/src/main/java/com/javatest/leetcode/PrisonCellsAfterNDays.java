package com.javatest.leetcode;

/*
* There are 8 prison cells in a row and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.

Return the state of the prison after n days (i.e., n such changes described above).*/
public class PrisonCellsAfterNDays {

    public static int[] prisonAfterNDays(int[] cells, int n) {
        // иначе мы если нет остатка, то вернет 0 ( нужен хотя бы один), при этом если n = 0 то и после остатка тоже 0
        n = (n - 1) % 14 + 1;
        while (n != 0) {
            int[] temp = new int[8];
            for (int i = 1; i < cells.length - 1; i++) {
                if ((cells[i - 1] == 1 && cells[i + 1] == 1) || (cells[i - 1] == 0 && cells[i + 1] == 0))
                    temp[i] = 1;

            }
            cells = temp;
            n--;
        }
        return cells;
    }


    public static void main(String[] args) {
        int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println(prisonAfterNDays(cells, 1000));
    }
}
