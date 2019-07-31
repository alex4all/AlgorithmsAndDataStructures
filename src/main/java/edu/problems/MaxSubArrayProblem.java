package edu.problems;


/**
 * NOT BEST SOLUTION FOR THIS PROBLEM
 * Just an example of Divide and Conquer technique
 */
public class MaxSubArrayProblem {

    public Segment process(int[] array) {
        return maxSubArray(array, 0, array.length - 1);
    }

    private Segment maxSubArray(int array[], int left, int right) {
        if (left == right)
            return new Segment(left, right, array[left]);
        int mid = (right + left) / 2;
        // find max sub-array in left half
        Segment leftSegment = maxSubArray(array, left, mid);
        // find max sub-array in right half
        Segment rightSegment = maxSubArray(array, mid + 1, right);
        // find max sub-array which starts in left half and ends in right half
        Segment crossSegment = maxCrossingSubArray(array, left, mid, right);

        if (leftSegment.sum >= rightSegment.sum && leftSegment.sum >= crossSegment.sum) {
            return leftSegment;
        } else if (rightSegment.sum >= crossSegment.sum) {
            return rightSegment;
        }
        return crossSegment;
    }

    /**
     * For this method mid point is fixed. Starting from this point we can go left and right trying to find max left and
     * max right sub-array. After this combine both results to get full crossing sub-array sum
     */
    private Segment maxCrossingSubArray(int[] array, int left, int mid, int right) {
        // looking for max sum in left half
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = mid;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum = sum + array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        // looking for max sum in right half
        int rightSum = Integer.MIN_VALUE;
        int maxRight = mid + 1;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum = sum + array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        // combine and return result
        return new Segment(maxLeft, maxRight, leftSum + rightSum);
    }

    /**
     * Entity to keep indexes of sub-array begin, end and sub-array sum
     */
    public static class Segment {
        public int begin;
        public int end;
        public int sum;

        public Segment(int begin, int end, int sum) {
            this.begin = begin;
            this.end = end;
            this.sum = sum;
        }
    }
}
