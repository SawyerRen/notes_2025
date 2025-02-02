import java.util.Arrays;

public class Q20 {
    public static int getWinnerCount(int[] a, int[] b, int[] c) {
        int max1 = 0, max2 = 0;
        for (int i = 0; i < a.length; i++) {
            int[] t = {a[i], b[i], c[i]};
            Arrays.sort(t);
            max1 = Math.max(max1, t[0]);
            max2 = Math.max(max2, t[1]);
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int[] t = {a[i], b[i], c[i]};
            Arrays.sort(t);
            if (t[1] > max1 && t[2] > max2) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getWinnerCount(new int[]{9, 4, 2}, new int[]{5, 12, 10}, new int[]{11, 3, 13}));
    }
}
