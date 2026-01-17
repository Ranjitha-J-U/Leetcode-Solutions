// LeetCode: Valid Anagram
// Difficulty: Easy
// Approach: Frequency Count using Array
// Time Complexity: O(n)
// Space Complexity: O(1)   (since array size is fixed to 26)

class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) return false;

        int[] frequencyCount = new int[26];

        // Count frequency of characters in string s
        for (int i = 0; i < s.length(); i++) {
            frequencyCount[s.charAt(i) - 'a']++;
        }

        // Decrease frequency using characters from string t
        for (int i = 0; i < t.length(); i++) {
            if (frequencyCount[t.charAt(i) - 'a'] > 0) {
                frequencyCount[t.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }

        return true;
    }
}
