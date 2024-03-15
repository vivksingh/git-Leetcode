import java.util.*;
import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, -2, 2, 1, 4, 2};
        int k = 7;
        Solution sol = new Solution();
        int res = sol.optimisedSubarraySum(nums, k);

        System.out.println(res);
    }


    public int optimisedSubarraySum(int[] nums, int k){
        int n = nums.length;
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0;i<n;i++){
            sum += nums[i];
            int presum = sum - k;

            if(map.containsKey(presum)) res += map.get(presum);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return res;
    }

    public static int subarraySum(int[] nums, int k) {
        int[] pref = new int[nums.length];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            pref[i] = sum;
        }
        int n = nums.length;
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(pref[i] - pref[j] == -k) count++;
                
            }
            if(pref[i] == k) count++;
        }

        return count;
    }
}