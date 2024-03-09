class Solution {
    public static int getCommon(int[] nums1, int[] nums2) {
        int num1 = 0;
        int num2 = 0;

        while(num1 < nums1.length && num2 < nums2.length){
            if(nums1[num1] == nums2[num2]) return nums1[num1];

            if(nums1[num1] > nums2[num2]) num2++;
            else num1++;
        
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,6};
        int[] nums2 = {-1,-1,0, 4, 6};

        System.out.println(getCommon(nums1, nums2));
    }
}