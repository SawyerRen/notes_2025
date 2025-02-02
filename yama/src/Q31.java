import java.util.Arrays;

public class Q31 {
    public static int[] getSuccessValue(int[] num_viewers, int[] queries) {
        Arrays.sort(num_viewers); // 先排序（O(n log n)）
        int n = num_viewers.length;

        // 计算前缀和（倒序，O(n)）
        int[] prefixSum = new int[n];
        prefixSum[n - 1] = num_viewers[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + num_viewers[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefixSum[n - queries[i]]; // 直接查询前缀和
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSuccessValue(
                new int[]{2, 5, 6, 3, 5}, new int[]{2, 3, 5}))); // [11, 16, 21]
        System.out.println(Arrays.toString(getSuccessValue(
                new int[]{7, 3, 5, 2}, new int[]{1, 4}))); // [7, 17]
        System.out.println(Arrays.toString(getSuccessValue(
                new int[]{7, 5, 6}, new int[]{1, 2, 3}))); // [7, 17]
    }
}

