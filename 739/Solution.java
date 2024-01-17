import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[t.length];

        for(int i=t.length-1;i>=0;i--){
            while(!stack.isEmpty() && t[i] >= t[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                res[i] = 0;
            }

            else{
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return res;
    }
}