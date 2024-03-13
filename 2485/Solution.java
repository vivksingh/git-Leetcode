import java.util.Arrays;

class Solution {
    public static int pivotInteger1(int n) {
        int total = (n*(n+1))/2;
        int sqrt = (int) Math.sqrt(total);
        if(sqrt * sqrt == total) return sqrt;
        return -1;
    }

    public static int pivotInteger2(int n) {
        int[] pref = new int[n];
        int[] post = new int[n];

        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += i;
            pref[i-1] = sum;
        }

        sum = 0;
        for(int i=n;i>0;i--){
            sum += i;
            post[i-1] = sum;
        }

        for(int i=0;i<n;i++){
            if(pref[i] == post[i]) return i+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger1(8));
        System.out.println(pivotInteger1(4));
        System.out.println(pivotInteger2(8));
        System.out.println(pivotInteger2(4));

    }

}


    
