// LeetCode: Two Sum
// Difficulty: Easy
// Approach: HashMap
// Time Complexity: O(n)
// Space Complexity: O(n)
🔗 LeetCode Profile: https://leetcode.com/u/Ranjitha_J_U/

import java.util.Scanner;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().replace("[","").replace("]","").split(",");
        int [] arr = new int[str.length];
        for(int i = 0; i <= arr.length - 1; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int target = sc.nextInt();
       int [] sum = twoSum(arr, target);
       System.out.println(sum);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++) { 
            int required = target - nums[i];
            if(map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }
            map.put(nums[i],i);
       }
    return new int[]{};
}
}
