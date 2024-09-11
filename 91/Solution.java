class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        
    }

    private int decodeWays(String s, int i, int[] dp){
        if(dp[i] != -1) return dp[i];

        if(i == s.length()){
            dp[i] = 1;
            return 1;
        }

        if(s.charAt(i) == '0'){
            dp[i] = 0;
            return 0;
        }

        int res = decodeWays(s, i+1, dp);
        if(i + 1 < s.length() && isValid(s.substring(i, i+2))) res += decodeWays(s, i+2, dp);

        dp[i] = res;
        return res;


    }

    private boolean isValid(String str){
        if(str.charAt(0) == '1' || (str.charAt(0) == '2' && str.charAt(1) <= '6')) return true;
        return false;
    }

}