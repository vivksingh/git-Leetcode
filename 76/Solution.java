import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        String res = "";
        if(m > n) return res;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0;i<m;i++){
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0)+1);
            map2.put(t.charAt(i), 0);
        }

        int left = 0;
        int len = n;
        int matches = 0;
        int reqmatches = t.length();
        for(int right=0;right<n;right++){
            if(matches != reqmatches){
                char r = s.charAt(right);
                if(map1.containsKey(r)){
                    map2.put(r, map2.get(r)+1);
                    if(map2.get(r) <= map1.get(r)) matches++;
                }
            }
            

            while(matches == reqmatches){
                if(right - left + 1 <= len){
                    len = right - left + 1;
                    res = s.substring(left,right+1);
                }

                if(map1.containsKey(s.charAt(left))){
                    map2.put(s.charAt(left), map2.get(s.charAt(left)) - 1);
                    if(map2.get(s.charAt(left)) < map1.get(s.charAt(left))) matches--;
                }
                left++;
            }
            
        }
        return res;    
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
