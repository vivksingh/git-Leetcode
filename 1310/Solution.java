class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        int[] dp = new int[n];
        int[] res = new int[m];
        dp[0] = arr[0];

        for(int i=1;i<n;i++) dp[i] = dp[i-1] ^ arr[i];

        for(int i=0;i<m;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            if(l == 0) res[i] = dp[r];
            else res[i] = dp[r] ^ dp[l - 1];
        }

        return res;
    }
}

// https://leetcode.com/problems/xor-queries-of-a-subarray/solutions/5779222/inverse-of-xor-is-xor-itself