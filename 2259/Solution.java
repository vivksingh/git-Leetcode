class Solution {
    public static String removeDigit(String number, char digit) {
        int n = number.length();
        for(int i=0;i<n-1;i++){
            if(digit == number.charAt(i) && number.charAt(i) < number.charAt(i+1))
                return (number.substring(0,i) + number.substring(i+1,n));
        }

        for(int i=n-1;i>=0;i--){
            if(digit == number.charAt(i))
            return (number.substring(0,i) + number.substring(i+1,n));
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(removeDigit("12341", '1'));
    }
}