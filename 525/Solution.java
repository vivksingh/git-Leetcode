import java.util.*;

class Solution {
    public static int findMaxLength(int[] nums) {
        int res = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0;i<n;i++){
            sum += nums[i] == 0 ? -1 : 1;


            if(map.containsKey(sum)) res = Math.max(res, i - map.get(sum));
            else map.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums= {1, 0, 1, 0, 0};
        System.out.println(findMaxLength(nums));
    }
}