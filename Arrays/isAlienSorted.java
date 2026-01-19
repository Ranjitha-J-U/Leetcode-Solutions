// LeetCode: Verifying an Alien Dictionary
// Difficulty: Easy
// -------------------------------------
// Approach: HashMap + Character-by-Character Comparison
// Time Complexity: O(n * m)
//   - n = number of words
//   - m = average length of each word
// Space Complexity: O(1)
//   - HashMap size is fixed to 26 characters

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> alienOrder = new HashMap<>();

        // Store alien character order
        for (int i = 0; i < order.length(); i++) {
            alienOrder.put(order.charAt(i), i);
        }

        outer:
        for (int i = 0; i < words.length - 1; i++) {

            inner:
            for (int j = 0; j < words[i].length(); j++) {

                // Case where next word is shorter but prefix is same
                if (j == words[i + 1].length()) return false;

                int difference =
                    alienOrder.get(words[i].charAt(j))
                  - alienOrder.get(words[i + 1].charAt(j));

                if (difference < 0) {
                    continue outer;   // correct order, check next word pair
                } else if (difference > 0) {
                    return false;    // wrong order
                } else {
                    continue;        // characters equal, check next char
                }
            }
        }
        return true;
    }
}
