// LeetCode: Product of Array Except Self
// Difficulty: Medium
// -------------------------------------
// Approach 1: Prefix & Postfix (Optimized)
// Time Complexity: O(n)
// Space Complexity: O(1)   (excluding output array)
//
// Approach 2: Division-based (Brute Force / Edge-case handling)
// Time Complexity: O(n)
// Space Complexity: O(1)
// Note: Division is not allowed in the problem statement.

class Solution {

    // -------- Approach 1: Prefix & Postfix (Optimal) --------
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }

    /*
     -------- Approach 2: Division-Based (Brute Force) --------
     Note: This approach is for understanding only.
     Division is not allowed as per problem constraints.

    public int[] productExceptSelf(int[] nums) {

        int multiplication = 1;
        int zeroCount = 0;
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                multiplication *= nums[i];
            } else {
                zeroCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (zeroCount == 0) {
                res[i] = multiplication / nums[i];
            } else if (zeroCount == 1 && nums[i] == 0) {
                res[i] = multiplication;
            } else {
                res[i] = 0;
            }
        }

        return res;
    }
    */
}
