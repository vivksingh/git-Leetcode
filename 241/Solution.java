import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> dp = new HashMap<>();
        return solve(expression, dp);
    }

    private List<Integer> solve(String str,  Map<String, List<Integer>> dp){
        if(dp.containsKey(str)) return dp.get(str);

        int n = str.length();
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            char cur = str.charAt(i);
            if(cur == '+' || cur == '-' || cur == '*'){
                List<Integer> l = solve(str.substring(0  , i), dp);
                List<Integer> r = solve(str.substring(i+1, n), dp);

                for(int k : l){
                    for(int j : r){
                        if(cur == '+') res.add(k + j);
                        if(cur == '-') res.add(k - j);
                        if(cur == '*') res.add(k * j);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.parseInt(str));
        dp.put(str, res);
        return res;
    }
}