package leetcode;


import java.util.ArrayList;

public class MedianOfTwo {
    public static double merge(int[] nums1, int[] nums2) {

        if (nums2.length == 0 && nums1.length != 0) {
            if (((double) nums1.length / 2) % 1 != 0)
                return nums1[nums1.length / 2];
            else
                return (double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
        }
        if (nums1.length == 0 && nums2.length != 0) {
            return merge(nums2, nums1);
        }
        double mid = (double) (nums1.length + nums2.length) / 2 + 1;

        ArrayList<Integer> fin = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            if ((double) fin.size() >= mid) {
                if ((double) fin.size() > mid)
                    return (double) fin.get((int) mid - 1);
                else return (double) (fin.get(fin.size() - 1) + fin.get(fin.size() - 2)) / 2;
            } else if (j != nums2.length) {
                if (i != nums1.length && nums1[i] < nums2[j]) {
                    fin.add(nums1[i]);
                    i++;
                } else {
                    fin.add(nums2[j]);
                    j++;
                }
            } else {
                fin.add(nums1[i]);
                i++;
            }
        }
        if ((double) fin.size() >= mid) {
            if ((double) fin.size() > mid)
                return (double) fin.get((int) mid - 1);
            else return (double) (fin.get(fin.size() - 1) + fin.get(fin.size() - 2)) / 2;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 6, 8, 9};
        int[] nums2 = new int[]{2,3,4,5,10};
        System.out.println(merge(nums1, nums2));
    }
}
