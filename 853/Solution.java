import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] car = new double[n][2];
        for(int i=0;i<n;i++){
            car[i] = new double[]{position[i], (target-position[i]) /(double) speed[i]};
        }

        Arrays.sort(car,(a,b) -> Double.compare(a[0],b[0]));
        Stack<Double> fleet = new Stack<>();

        for(int i=0;i<n;i++){
            while(!fleet.isEmpty() && car[i][1] >= fleet.peek()) fleet.pop();

            fleet.push(car[i][1]);
        }

        return fleet.size();
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position ={10, 8, 0, 5, 3};
        int[] speed = {2, 4 , 1, 1, 3};

        System.out.println(carFleet(target, position, speed));
    }
}