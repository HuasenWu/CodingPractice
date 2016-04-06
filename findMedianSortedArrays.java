// Find the median of two sorted arrays in O(log(m + n)) time.
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKthSortedArrays(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKthSortedArrays(nums1, 0, nums2, 0, len / 2) + findKthSortedArrays(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }
    private double findKthSortedArrays(int[] nums1, int start1, 
                                       int[] nums2, int start2, 
                                       int k) {
        if (start1 >= nums1.length) {
            return (double)nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return (double)nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int key1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int key2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (key1 < key2) {
            return findKthSortedArrays(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKthSortedArrays(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
