package leet_code.arrays.sec015_3Sum;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((i != j) && (i != k) && (j != k)
                            && (nums[i] + nums[j] + nums[k] == 0)
                            && !isDuplicate(result, List.of(nums[i], nums[j], nums[k]))) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }

    public boolean isDuplicate(List<List<Integer>> numsList, List<Integer> nums) {
        return numsList.stream().anyMatch(integers -> integers.containsAll(nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        System.out.println(solution.threeSum(nums));
    }
}
