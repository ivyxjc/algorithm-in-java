package xyz.ivyxjc.algorithm.introduction

import com.google.common.base.Preconditions


/**
 * Solution 1 starts
 * Introduction to Algorithms P40
 *
 * LeetCode 53. Maximum Subarray
 *
 * Time: O(n lgn)
 */
private fun maxSubArray(arr: IntArray, lo: Int, hi: Int): Result {
    if (hi == lo) {
        return Result(lo, hi, arr[lo])
    } else {
        var mi = (lo + hi) / 2
        val resL = maxSubArray(arr, lo, mi)

        val resR = maxSubArray(arr, mi + 1, hi)

        val resCro = maxSubArrayCross(arr, lo, mi, hi)

        if ((resL.sum >= resR.sum) and (resL.sum >= resCro.sum)) {
            return resL
        } else if ((resR.sum >= resL.sum) and (resR.sum >= resCro.sum)) {
            return resR
        } else {
            return resCro
        }
    }

}

private fun maxSubArrayCross(arr: IntArray, lo: Int, mi: Int, hi: Int): Result {
    var leftSum = Int.MIN_VALUE
    var rightSum = Int.MIN_VALUE
    var sum = 0
    var maxLeft = mi
    var maxRight = mi
    for (i in mi downTo lo) {
        sum += arr[i]
        if (sum > leftSum) {
            leftSum = sum
            maxLeft = i
        }
    }
    sum = 0
    for (i in mi + 1..hi) {
        sum += arr[i]
        if (sum > rightSum) {
            rightSum = sum
            maxRight = i
        }
    }
    return Result(maxLeft, maxRight, leftSum + rightSum)

}


private data class Result(val low: Int, val high: Int, val sum: Int)

// Solution 1 ends


/**
 * Solution 2 starts
 * Brute force search
 * Time: O(n*n)
 */
private fun maxSubArrayBruteForce(arr: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var sum = 0
    for (i in 0 until arr.size) {
        sum = 0
        for (j in i until arr.size) {
            sum += arr[j]
            if (sum > maxSum) {
                maxSum = sum
            }
        }
    }
    return maxSum
}

// Solution 2 ends


/**
 * Solution 3 starts
 */
private fun maxSubArray3(arr: IntArray): Int {
    var maxRight = 0
    var maxSum = arr[0]

    for (i in 1 until arr.size) {
        var s = maxSum
        for (j in maxRight + 1..i) {
            s += arr[j]
        }
        if (s >= maxSum) {
            maxRight = i
            maxSum = s
        }
        if (arr[i] >= maxSum) {
            maxSum = arr[i]
        }
    }
    return maxSum
}

//Solution 3 end

private class Solution {
    fun maxSubArray(nums: IntArray): Int {
        return maxSubArray3(nums)
//        return maxSubArrayBruteForce(nums)
//        return maxSubArray(nums, 0, nums.size - 1).sum
    }
}

fun main() {
    val arr1 = arrayOf(1, 2, 3, 4, 5, -5, 18, 23, 45).toIntArray()
    val arr2 = arrayOf(1, 2).toIntArray()
    val arr3 = arrayOf(-1, -2, -3).toIntArray()
    val arr4 = arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4).toIntArray()
    val solution = Solution()
    val res1 = solution.maxSubArray(arr1)
    val res2 = solution.maxSubArray(arr2)
    val res3 = solution.maxSubArray(arr3)
    val res4 = solution.maxSubArray(arr4)
    println(res1)
    println(res2)
    println(res3)
    println(res4)
    Preconditions.checkArgument(res1 == 96)
    Preconditions.checkArgument(res2 == 3)
    Preconditions.checkArgument(res3 == -1)
    Preconditions.checkArgument(res4 == 6)
}


