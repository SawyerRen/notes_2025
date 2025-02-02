import java.util.Arrays;
import java.util.PriorityQueue;

public class Q12 {
    public static long maxTransferRate(int[] throughput, int pipelineCount) {
        int n = throughput.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int k : throughput) {
            for (int i : throughput) {
                pq.add(k + i);
                if (pq.size() > pipelineCount) {
                    pq.poll();
                }
            }
        }
        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }

    public static int maxTransferRate2(int[] throughput, int pipelineCount) {
        int n = throughput.length;
        Arrays.sort(throughput);

        // 构建前缀和数组
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + throughput[i];
        }

        // 二分查找确定阈值 t
        int low = throughput[0] * 2;
        int high = throughput[n - 1] * 2 + 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (countPairs(throughput, mid) >= pipelineCount) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int t = low - 1;

        // 计算总传输速率
        long totalSum = 0;
        int totalPairs = 0;
        int j = n - 1;
        for (int k : throughput) {
            while (j >= 0 && k + throughput[j] >= t) {
                j--;
            }
            int cnt = n - j - 1;
            totalPairs += cnt;
            totalSum += (long) k * cnt + (prefix[n] - prefix[j + 1]);
        }

        // 调整多余的对数
        int excess = totalPairs - pipelineCount;
        totalSum -= (long) excess * t;
        return (int) totalSum;
    }

    // 计算满足和 ≥ t 的对数
    private static int countPairs(int[] throughput, int t) {
        int count = 0;
        int j = throughput.length - 1;
        for (int k : throughput) {
            while (j >= 0 && k + throughput[j] >= t) {
                j--;
            }
            count += throughput.length - j - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 5};
        System.out.println(maxTransferRate(a, 4));
        System.out.println(maxTransferRate2(a, 4));
    }
}
