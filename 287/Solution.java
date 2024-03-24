public class Solution {
    public static int findDuplicate(int[] nums) {
        int[] count = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count[num]++;

            if (count[num] > 1) {
                return num;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}