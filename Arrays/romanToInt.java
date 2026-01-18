// LeetCode: Roman to Integer
// Difficulty: Easy
// -------------------------------------
// Approach: HashMap + Previous Value Comparison
// Time Complexity: O(n)
//   - n = length of the string
// Space Complexity: O(1)
//   - Map size is fixed (7 Roman symbols)

class Solution {
    public int romanToInt(String s) {

        // Map Roman symbols to their values
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanValues.get(s.charAt(i));

            result += currentValue;

            // If previous value is smaller, subtract twice the previous
            if (prevValue < currentValue) {
                result -= 2 * prevValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
}
