class Solution {
    public static int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] fre = new int[101];
        int res = 0;
        int max = 0;

        for(int i=0;i<n;i++){
            fre[nums[i]]++;
            max = Math.max(max, fre[nums[i]]);
        }

        int count = 0;
        for(int i=0;i<101;i++){
            if(fre[i] == max) count++;
        }
        
        return max * count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};
        System.out.println(maxFrequencyElements(nums));
    }
}