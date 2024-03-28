import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            int indx = Math.abs(nums[i]) - 1;
            
            if(nums[indx] < 0) res.add(Math.abs(nums[i]));
            else nums[indx] = -nums[indx];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

}