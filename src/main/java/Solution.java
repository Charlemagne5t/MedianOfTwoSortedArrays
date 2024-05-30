public class Solution {
    public double findMedianSortedArrays(int[] array1, int[] array2) {
        if(array1.length == 0) {
            return array2.length % 2 == 0 ? (double) (array2[array2.length / 2] + array2[array2.length / 2 - 1]) / 2 : (double) array2[array2.length / 2];
        }else if(array2.length == 0) {
            return array1.length % 2 == 0 ? (double) (array1[array1.length / 2] + array1[array1.length / 2 - 1]) / 2 : (double) array1[array1.length / 2];
        }
        int[] big;
        int[] small;
        if (array1.length > array2.length) {
            big = array1;
            small = array2;
        } else {
            big = array2;
            small = array1;
        }

        int totalLength = array1.length + array2.length;
        if(small.length < big.length && small[small.length - 1] < big[0]) {
            if(totalLength % 2 == 0) {
                int start = totalLength / 2 - small.length;
                return (double)(big[start] + big[start - 1]) / 2;
            }else {
                int start = totalLength / 2 - small.length;
                return (double)(big[start]);
            }
        }
        if(small[0] > big[big.length - 1]) {
            if(totalLength % 2 == 0) {
                return (double)(big[totalLength / 2] + big[totalLength / 2 - 1]) / 2;
            }else {
                return (double)(big[totalLength / 2]);
            }
        }
        if (totalLength % 2 == 0) {
            int half = totalLength / 2;

            int l = 0;
            int r = Math.min(small.length - 1, half - 1);

            int m = l + (r - l) / 2;

            while (l <= r) {
                m = l + (r - l) / 2;
                int ch = check(small, m + 1, big, totalLength / 2 - m - 1);
                if(ch == 0) {
                    double res = (double) small[m];
                    res += big[half - m - 1];
                    return res / 2;
                }
                if(ch == -1) {
                    r = m - 1;
                }
                if(ch == 1) {
                    l = m + 1;
                }
            }
        } else {
            int half = totalLength / 2;
            int l = 0;
            int r = Math.min(small.length - 1, half);
            int m = l + (r - l) / 2;
            while (l <= r) {
                m = l + (r - l) / 2;
                int ch = check(small, m + 1, big, totalLength / 2 - m);
                if(ch == 0) {
                    return small[m];
                }
                if(ch == -1) {
                    r = m - 1;
                }
                if(ch == 1) {
                    l = m + 1;
                }
            }

        }
        return 0;
    }
    int checkOdd(int[] small, int ls, int[] big, int lb) {
        return 0;
    }
    int check(int[] small, int lengthSmall, int[] big, int lengthBig) {
        int indexSmall = lengthSmall - 1;
        int indexBig = lengthBig - 1;
        if (indexBig < big.length - 1 && small[indexSmall] > big[indexBig + 1]) {
            return -1;
        }
        if(indexSmall < small.length - 1 && indexBig > 0 && big[indexBig] > small[indexSmall + 1]) {
            return 1;
        }

        return 0;
    }

}