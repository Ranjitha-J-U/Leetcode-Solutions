// LeetCode: Top K Frequent Elements
// Difficulty: Medium
// -------------------------------------
// Approach: HashMap + Min Heap (PriorityQueue)
// Time Complexity: O(n log k)
//   - n = number of elements
// Space Complexity: O(n + k)
//   - HashMap for frequencies
//   - Heap of size k

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Edge case
        if (k == nums.length) return nums;

        // Step 1: Count frequency of each number
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int x : nums) {
            freqCount.put(x, freqCount.getOrDefault(x, 0) + 1);
        }

        // Step 2: Min heap based on frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freqCount.get(a) - freqCount.get(b)
        );

        // Step 3: Keep only top k frequent elements in heap
        for (int x : freqCount.keySet()) {
            minHeap.add(x);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract elements from heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
