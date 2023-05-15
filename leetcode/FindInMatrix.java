/*Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

package leetcode;

public class FindInMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,4,7,11,15,16},{2,5,8,12,19,22}, {3,6,9,16,22,24},{10,13,14,17,24,27},{18,21,23,26,30,36}};

        if (matrix1[0].length == 0 || matrix1 == null || matrix1.length == 0){
            return;
        }
        System.out.println(matrix1[0].length);
        int k = 14;

        int i = 0, j = matrix1[0].length - 1;

        while(i < matrix1.length && j >= 0){
            if(matrix1[i][j] == k){
                System.out.println("TRUE");
                break;
            }
            if(matrix1[i][j] > k) j--;
            else i++;
        }

    }
}




