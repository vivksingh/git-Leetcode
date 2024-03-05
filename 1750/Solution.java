class Solution {
    public static int minimumLength(String s) {
        int n = s.length();
        int left = 0;
        int right = n-1;

        while(left < right && s.charAt(left) == s.charAt(right)){
            char cur = s.charAt(left);

            while(left < right && s.charAt(left) == s.charAt(right)) left++;
            while(left <= right && s.charAt(right) == cur) right--;
        }

        return right - left +1;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("abaabbbccbba"));
    }
}