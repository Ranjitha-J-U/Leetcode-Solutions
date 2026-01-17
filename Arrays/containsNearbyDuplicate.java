// LeetCode: Contains Duplicate II
// Difficulty: Easy
// Approach: Sliding Window + HashSet
// Time Complexity: O(n)
// Space Complexity: O(min(n, k)) -- If k is smaller than n, the HashSet size is limited to k. If k is larger than or equal to n, the set stores all n elements.Therefore, space complexity is O(min(n, k)).

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // O(1) average time
            if (window.contains(nums[i])) {
                return true;
            }

            // O(1) average time
            window.add(nums[i]);

            // Maintain window size of at most k
            if (window.size() > k) {
                // O(1) average time
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
