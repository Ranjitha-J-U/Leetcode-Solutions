// LeetCode: containsDuplicate
// Difficulty: Easy
// Approach: HashSet
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set <Integer> seenNumbers = new HashSet<>();
        for(int x : nums) {
            if(seenNumbers.contains(x)) {
                return true; // If duplicates present
            }
        seenNumbers.add(x); // Add the element which is not present 
        }
        return false; 
    }
}
