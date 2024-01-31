import java.util.ArrayDeque;
import java.util.Deque;

class Solution{
    public static int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] prevless = new int[n];
        int[] nextless = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!deque.isEmpty() && nums[i] <= nums[deque.peek()]) deque.pop();

            if(deque.isEmpty()) prevless[i] = -1;
            else prevless[i] = deque.peek();

            deque.push(i);
        }

        deque.clear();

        for(int i=n-1;i>=0;i--){
            while(!deque.isEmpty() && nums[i] <= nums[deque.peek()]) deque.pop();

            if(deque.isEmpty()) nextless[i] = n;
            else nextless[i] = deque.peek();

            deque.push(i);
        }

        int res = 0;
        for(int i=0;i<n;i++){
            int curr_max = nums[i] * (nextless[i] - prevless[i] -1);
            res = Math.max(res, curr_max);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {2,1,5,6,2};
        System.out.println(largestRectangleArea(input));
    }
}