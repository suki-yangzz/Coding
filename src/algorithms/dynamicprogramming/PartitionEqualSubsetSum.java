package algorithms.dynamicprogramming;

/*
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Note:
 * Both the array size and each of the array element will not exceed 100.
 */
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n:nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false;
        // dp[i][j] 表示 如果我们取前i个数字，且背包容量为j的情况下，最多能放入多少东西
        int[][] dp = new int[nums.length][sum/2 + 1];
        dp[0][0] = 0;
        for(int j = nums[0]; j <= sum/2; j++){
            dp[0][j] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for(int j = nums[i]; j <= sum/2; j++){
                dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
            }
        }
        if (dp[nums.length - 1][sum/2] == sum/2)
            return true;
        else
            return false;
    }

    public static void main (String[] args) {
        int[] nums = {2, 4, 5, 7};
        System.out.println(canPartition(nums));
    }

}
