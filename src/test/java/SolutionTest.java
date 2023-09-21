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
}
