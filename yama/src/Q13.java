import java.util.ArrayList;
import java.util.HashMap;

public class Q13 {
    public static int calculateTotalBalanced(int[] capacities) {
        int n = capacities.length;
        int[] prefixSum = new int[n + 1];
        HashMap<Integer, ArrayList<Integer>> capacityIndexMap = new HashMap<>();

        // 构建前缀和与容量索引映射
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + capacities[i];
            capacityIndexMap.putIfAbsent(capacities[i], new ArrayList<>());
            capacityIndexMap.get(capacities[i]).add(i);
        }

        int res = 0;

        // 遍历每个唯一容量值及其对应的节点索引
        for (Integer capacity : capacityIndexMap.keySet()) {
            ArrayList<Integer> indexList = capacityIndexMap.get(capacity);
            HashMap<Integer, Integer> counter = new HashMap<>();

            // 计算满足平衡条件的配对
            for (int index : indexList) {
                int currentPrefixSum = prefixSum[index + 1];
                int removedSides = currentPrefixSum - 2 * capacity;
                int target = removedSides - 2 * capacity;

                // 累加符合匹配条件的计数
                res += counter.getOrDefault(target, 0);

                // 更新当前前缀和的计数
                counter.put(removedSides, counter.getOrDefault(removedSides, 0) + 1);
            }
        }

        return res;
    }

    // 测试示例
    public static void main(String[] args) {
        int[] sampleCapacities = {2, 1, 2, 3, 2};
        System.out.println(calculateTotalBalanced(sampleCapacities));
        System.out.println(calculateTotalBalanced(new int[]{9, 3, 1, 2, 3, 9, 10}));
        System.out.println(calculateTotalBalanced(new int[]{6, 1, 2, 3, 6}));
        System.out.println(calculateTotalBalanced(new int[]{9, 3, 3, 3, 9}));
    }
}
