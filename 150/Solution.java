import java.util.Stack;

class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String curr = tokens[i];

            if(!curr.equals("+") && !curr.equals("-") && !curr.equals("*") && !curr.equals("/") ){
                stack.push(Integer.valueOf(curr));
            }

            else{
                int secnd = stack.pop();
                int first = stack.pop();
                int res = operation(first, secnd, curr.charAt(0));
                stack.push(res);
            }
        }
        return stack.pop();
    }

    private static int operation(int a, int b, char o){
        if(o == '+') return a+b;
        else if(o == '-') return a-b;
        else if(o == '*') return a*b;
        else if(o == '/') return a/b;
        return 0;
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}