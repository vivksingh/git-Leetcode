class Solution {
    public static String customSortString(String order, String s) {
        char[] res = new char[s.length()];
        int[] fre = new int[26];
        
        for(int i=0;i<s.length();i++) fre[s.charAt(i) - 'a']++;

        int indx = 0;
        for(int i=0;i<order.length();i++){
            char cur = order.charAt(i);
            while(fre[cur - 'a']-- != 0) res[indx++] = cur;
            
        }

        for(int i=0;i<26;i++){
            while(fre[i]-- > 0) res[indx++] = (char) (i + 'a');
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String or = "bcdf";
        String str = "abgfgaihhvckakhai";
        System.out.println(customSortString(or, str));
    }
}