import java.util.Arrays;

public class Q26 {
    public static long amazonGetMaxThroughput(int[] host_throughput) {
        Arrays.sort(host_throughput);
        int n = host_throughput.length;
        int count = n / 3;  // Maximum number of clusters that can be formed
        long res = 0;
        int index = n - 2;
        while (count-- > 0) {
            res += host_throughput[index];
            index -= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(amazonGetMaxThroughput(new int[]{4, 6, 3, 5, 4, 5}));
        System.out.println(amazonGetMaxThroughput(new int[]{2, 3, 4, 3, 4}));
    }
}
