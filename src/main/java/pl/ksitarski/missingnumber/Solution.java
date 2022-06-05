package pl.ksitarski.missingnumber;

class Solution {
    public int missingNumber(int[] nums) {
        int missingNumberCombination = 0;

        for (int i = 0; i <= nums.length; i++) {
            missingNumberCombination ^= i;

            if (i < nums.length) {
                missingNumberCombination ^= nums[i];
            }
        }


        return missingNumberCombination;
    }
}
