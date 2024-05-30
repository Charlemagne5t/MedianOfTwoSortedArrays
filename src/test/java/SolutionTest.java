import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void findMedianSortedArraysTest1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double delta = 1e-5;
        double expected = 2.00000;
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void findMedianSortedArraysTest2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double delta = 1e-5;
        double expected = 2.50000;
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(expected, actual, delta);
    }
    @Test
    public void findMedianSortedArraysTest3() {
        int[] nums1 = {3};
        int[] nums2 = {-2, -1};
        double delta = 1e-5;
        double expected = -1;
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(expected, actual, delta);
    }
    @Test
    public void findMedianSortedArraysTest4() {
        int[] nums1 = {1,2};
        int[] nums2 = {-1, 3};
        double delta = 1e-5;
        double expected = 1.5;
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);

        Assert.assertEquals(expected, actual, delta);
    }
}
