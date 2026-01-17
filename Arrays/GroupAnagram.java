// LeetCode: Group Anagrams
// Difficulty: Medium
// Approach: HashMap + Character Frequency Count
// Time Complexity: O(n * k)
//   - n = number of strings
//   - k = average length of each string
// Space Complexity: O(n * k)
//   - for storing grouped anagrams in HashMap

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        // Edge case
        if (strs.length == 0) return new ArrayList<>();

        for (String x : strs) {

            // Frequency array for characters a-z
            int[] freq = new int[26];

            for (int i = 0; i < x.length(); i++) {
                freq[x.charAt(i) - 'a']++;
            }

            // Build a unique key from frequency array
            StringBuilder sb = new StringBuilder();
            for (int count : freq) {
                sb.append("#").append(count);
            }

            String key = sb.toString();

            // Add string to corresponding anagram group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(x);
        }

        // Convert map values to result list
        return new ArrayList<>(map.values());
    }
}
