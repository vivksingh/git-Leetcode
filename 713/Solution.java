class Solution {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int product = 1;

        while(right < n){
            product *= nums[right];

            while(product >= k && left <= right){
                product /= nums[left];
                left++;
            }
            
            res += right - left +1;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
    
}