import java.util.Arrays;

public class Q30 {
    public static long getPairsCount(int[] process, int k) {
        Arrays.sort(process);
        long res = 0;
        int left = 0, right = 1;

        while (right < process.length) {
            if (process[right] - process[left] <= k) {
                res += (right - left);
                right++;
            } else {
                left++;
                if (left == right) right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPairsCount(new int[]{100, 200, 300, 400}, 250)); // Output: 5
        System.out.println(getPairsCount(new int[]{10, 12, 11}, 0));           // Output: 0
        System.out.println(getPairsCount(new int[]{7, 10, 13, 11}, 3));           // Output: 0
    }
}
