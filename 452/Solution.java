import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        int count = 1;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int[] prev = points[0];

        for (int i = 1; i < n; i++) {
            int curPointStart = points[i][0];
            int curPointEnd = points[i][1];

            int prevPointStart = prev[0];
            int prevPointEnd = prev[1];

            if (prevPointEnd < curPointStart) {
                count++;
                prev = points[i];

            } else {
                prev[0] = Math.max(curPointStart, prevPointStart);
                prev[1] = Math.min(curPointEnd, prevPointEnd);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }

}