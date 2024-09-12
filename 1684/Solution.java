class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int n = words.length;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<allowed.length();i++) set.add(allowed.charAt(i));

        for(int i=0;i<n;i++){
            boolean flag = true;
            String str = words[i];

            for(int j=0;j<str.length();j++){
                if(!set.contains(str.charAt(j))){
                    flag = false;
                    break;
                }
            }

            if(flag) res++;
        }

        return res;
    }
}