public class Solution {
    public double findMedianSortedArrays(int[] array1, int[] array2) {
        if (array1.length > array2.length) {
            int[] temp = array1;
            array1 = array2;
            array2 = temp;
        }

        int m = array1.length;
        int n = array2.length;
        int left = 0;
        int right = m;
        int halfLen = (m + n + 1) / 2;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = halfLen - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : array1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : array1[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : array2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : array2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }

        return -1;
    }
}
