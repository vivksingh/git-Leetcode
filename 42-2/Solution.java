class Solution{
    public static int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] >= leftmax) leftmax = height[left];
                else res += leftmax -height[left];
                left++;
            }

            else{
                if(height[right] >= rightmax) rightmax = height[right];
                else res += rightmax - height[right];
                right--;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }
}