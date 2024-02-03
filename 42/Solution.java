import java.util.Arrays;

class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        int res = 0;
        int max;

        max = height[0];
        for(int i=0;i<n;i++){
            leftmax[i] = max;
            max = Math.max(max,height[i]);
        }
        System.out.println(Arrays.toString(leftmax));

        max = height[n-1];
        for(int i=n-1;i>=0;i--){
            rightmax[i] = max;
            max = Math.max(max, height[i]);
        }
        System.out.println(Arrays.toString(rightmax));

        for(int i=0;i<n;i++){
            int water = Math.min(leftmax[i],rightmax[i]) - height[i];
            if(water > 0) res += water;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }
}