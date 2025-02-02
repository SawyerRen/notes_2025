import java.util.Arrays;

public class Q21 {
    public static int getScoreDifference(int[] points) {
        // 将数组从小到大排序，然后从后往前遍历获得降序效果
        Arrays.sort(points);
        int p1 = 0, p2 = 0;
        int n = points.length;
        int steps = 0;
        // 从最大的元素开始，交替累加到 p1 和 p2
        for (int i = n - 1; i >= 0; i--) {
            if (steps % 2 == 0) {
                p1 += points[i];
            } else {
                p2 += points[i];
            }
            steps++;
        }
        return p1 - p2;
    }

    public static void main(String[] args) {
        int[] points = {1, 3, 3};
        System.out.println(getScoreDifference(points));
        points = new int[]{4, 1, 2, 3};
        System.out.println(getScoreDifference(points));
    }
}
