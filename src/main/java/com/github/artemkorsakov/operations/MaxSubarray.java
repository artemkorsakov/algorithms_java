package com.github.artemkorsakov.operations;

import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MaxSubarray {
    private int leftIndex;
    private int rightIndex;
    private long maxSum;

    public static MaxSubarray findMaxSubarray(long[] array, int low, int high) {
        if (low == high) {
            return new MaxSubarray(low, high, array[low]);
        }

        int mid = (low + high) / 2;
        MaxSubarray maxSubarrayLeft = findMaxSubarray(array, low, mid);
        MaxSubarray maxSubarrayRight = findMaxSubarray(array, mid + 1, high);
        MaxSubarray maxSubarrayMid = findMaxCrossingSubarray(array, low, mid, high);
        if (maxSubarrayLeft.getMaxSum() >= maxSubarrayMid.getMaxSum()
                && maxSubarrayLeft.getMaxSum() >= maxSubarrayRight.getMaxSum()) {
            return maxSubarrayLeft;
        }
        if (maxSubarrayRight.getMaxSum() >= maxSubarrayMid.getMaxSum()
                && maxSubarrayRight.getMaxSum() >= maxSubarrayLeft.getMaxSum()) {
            return maxSubarrayRight;
        }
        return maxSubarrayMid;
    }

    private static MaxSubarray findMaxCrossingSubarray(long[] array, int low, int mid, int high) {
        long leftSum = Long.MIN_VALUE;
        long sum = 0;
        int maxLeft = high;
        for (int i = mid; i >= low; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        long rightSum = Long.MIN_VALUE;
        sum = 0;
        int maxRight = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new MaxSubarray(maxLeft, maxRight, leftSum + rightSum);
    }

}
