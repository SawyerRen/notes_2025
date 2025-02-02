import java.util.Arrays;

public class Q56 {
    public static int minLag(int[] centers, int[] servers) {
        Arrays.sort(centers);
        Arrays.sort(servers);
        int totalLag = 0;

        for (int i = 0; i < centers.length; i++) {
            totalLag += Math.abs(centers[i] - servers[i]);
        }
        return totalLag;
    }

    public static void main(String[] args) {
        int[] centers1 = {1, 5, 9};
        int[] servers1 = {2, 6, 8};
        System.out.println(minLag(centers1, servers1));  // 输出: 3

        int[] centers2 = {3, 8, 1, 4};
        int[] servers2 = {7, 2, 6, 5};
        System.out.println(minLag(centers2, servers2));  // 输出: 6
    }
}
