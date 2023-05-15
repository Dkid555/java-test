package leetcode;

public class FindInIncreaseMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5,6},{7,8,9,10,11,12}, {13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}};
        if(matrix == null ||
                matrix[0].length == 0 || matrix.length == 0)    return;
        int target = 13;
        int row = matrix.length, col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        int mid;
        while(start <= end){
            mid = start +(end - start)/2;
            int mid_val = matrix[mid / col][mid % col];
            if(target == mid_val) {
                System.out.println("True");
                break;
            }else if(target < mid_val) end = mid - 1;
            else start = mid + 1;


        }
    }
}
