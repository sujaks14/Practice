package test.Array;

import java.util.Arrays;

public class PartitionEqualSum {

    public static void main(String[] args) {
        System.out.println("enters  PartitionEqualSum:: main");
        int[] arr = new int[] {5,2,2,1,0};
        boolean result = canPartition(arr);
        System.out.println("result: " + result);

    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        System.out.println("half sum  " + sum );


        int n = nums.length;
        boolean[] dp = new boolean[sum+1];

        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        return dp[sum];
    }
}

/**

 Dynamic programming solution:
 Calculating the sum of all members in the array, and find if is there any subsets of the array has sum equal to sum/2
 The general DP formula is:

 dp[n][W] = dp[n - 1][W - a[n-1]] || dp[n - 1][W]
 Detail solution:

 public class Solution {

 public boolean canPartition(int[] nums) {
 int sum = 0;
 for (int i = 0; i < nums.length; i++) {
 sum += nums[i];
 }
 if (sum %2 != 0) return false;
 sum /= 2;

 boolean dp[][] = new boolean[nums.length + 1][sum + 1];

 for (int i = 0; i < nums.length + 1; i++) {
 for (int j = 0; j < sum + 1; j ++) {
 if (i == 0 || j == 0)
 dp[i][j] = false;
 }
 }

 dp[0][0] = true;

 for (int i = 1; i < nums.length + 1; i++) {
 for (int j = 1; j < sum + 1; j++) {
 if (j >= nums[i- 1])
 dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
 else
 dp[i][j] = dp[i - 1][j];
 }
 }

 return dp[nums.length][sum];
 }
 }
 */