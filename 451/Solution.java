import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String frequencySortforlowercase(String s) {
        int[] map = new int[26];
        int n = s.length();

        for(int i=0;i<n;i++) map[s.charAt(i) - 'a']++;

        String res = "";
        for(int i=0;i<26;i++){
            while(map[i] != 0){
                res += (char)('a' + i);
                map[i]--;
            }
        }
        return res;
    }

    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }

        Character[] str = new Character[n];
        for(int i=0;i<n;i++) str[i] = s.charAt(i);

        Arrays.sort(str, new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b){
                return -Integer.compare(map.get(a),map.get(b));
            }            
        });

        String res = "";
        for(int i=0;i<n;i++) res += str[i];
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
}