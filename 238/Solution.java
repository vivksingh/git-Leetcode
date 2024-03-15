import java.util.Arrays;

class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res= new int[n];

        res[0]=nums[0];
        for(int i=1;i<n;i++){
            res[i] = res[i-1] * nums[i];
        }

        int lastpost = nums[n-1];
        res[n-1] = res[n-2];
        for(int i = n-2;i>0;i--){
            res[i] = res[i-1] * lastpost;
            lastpost *= nums[i];
        }
        res[0] = lastpost;

        return res;
        
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}