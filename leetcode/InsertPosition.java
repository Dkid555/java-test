package leetcode;
/*
* public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if(nums.length == 1){
            if(nums[0] >= target) return 0;
            return 1;
        }
        if(nums[low] > target) return 0;
        if(nums[high] < target) return nums.length;
        while(low < high){
            if(nums[low] == target || nums[high] == target){
                if(nums[low] == target) return low;
                else return high;
            }
            else if(nums[low] < target) {
                if(nums[low + 1] > target) return low + 1;
                low++;
                }
            else if(nums[high] > target){
                if(nums[high - 1] < target) return high - 1;
            high--;}
        }
        return nums.length;
    }
*
* */

public class InsertPosition {
    public static int search(int[] nums, int target){
        if(nums.length == 1){
            if(nums[0] >= target) return 0;
            return 1;
        }
        if(nums[0] > target) return 0;
        if(nums[nums.length - 1] < target) return nums.length;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 3;
        System.out.println(search(nums, 2));
    }
}
