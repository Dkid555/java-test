package leetcode;

public class FindGaps {
    static int[][] Gaps(int[][] nums){
        int[][] gap = new int[nums.length - 1][nums[0].length];
        for(int i = 1; i < nums.length;i++){
            gap[i-1][0] = nums[i-1][1];
            gap[i-1][1] = nums[i][0];
        }
        return gap;
    }
    static int Gaps1(int[][] nums, int lenght){
        int[][] gap = new int[nums.length - 1][nums[0].length];
        for(int i = 1; i < nums.length;i++){
            if(nums[i][0] - nums[i-1][1] >= lenght) return nums[i][0];
            //gap[i-1][0] = nums[i-1][1];
            //gap[i-1][1] = nums[i][0];
        }
        return -1;
    }
    static int intersect(int[][]gap1, int[][]gap2, int lenght){
        if(gap2.length < gap1.length) return intersect(gap1,gap2, lenght);
        for(int i = 0; i < gap1.length; i++)
        {
            if(gap1[i][1] - gap1[i][0] >= lenght && gap2[i][1] - gap2[i][0] >= lenght)
            return Math.max(gap1[i][0], gap2[i][0]);
        }

        return -1;
    }
    public static void main(String[] args) {
        int lenght = 100;
        int[][] nums = new int[][]{{100,220},{230,440},{780,900},{1000,5000}};
        int[][] nums2 = new int[][]{{100,180},{200,500},{800,950},{1050,1200},{1200,3000}};
        int[][] nums3 = new int[][]{{100,180},{200,500},{800,950}};
        int[][] nums1 = Gaps(nums);
        int a = Gaps1(nums, lenght);

        int b = intersect(Gaps(nums), Gaps(nums2), lenght);
    }
}
