import java.util.ArrayList;
import java.util.*;

class Solution{
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] str_arr=str.toCharArray();
            Arrays.sort(str_arr);
            String key=String.valueOf(str_arr);

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(str);   
        }

        return new ArrayList<>(map.values());
    }

    public static void prntarr(String[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        
        // for(List<String> list:groupAnagrams(strs)){
        //     for(String str:list){
        //         System.out.print(str+" ");
        //     }
        //     System.out.println();
        // }

        String str="ausga";
        char[] ca=new char[26];
        
        for(char c:str.toCharArray()){
            ca[c-'a']++;
        }
        String keystr=String.valueOf(ca);
        System.out.println(keystr);
        for(int i=0;i<26;i++){
            System.out.print(ca[i]+" ");
        }
    }
}