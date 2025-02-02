import java.util.Arrays;

public class Q32 {
    public static int getMaxMemoryPoints(int[] memory) {
        Arrays.sort(memory); // 先升序排列
        int n = memory.length;
        int total = 0, prefixSum = 0;

        for (int i = n - 1; i >= 0; i--) { // 逆序计算前缀和
            prefixSum += memory[i];
            total += prefixSum;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(getMaxMemoryPoints(new int[]{3, 4, 5})); // 输出: 26
        System.out.println(getMaxMemoryPoints(new int[]{1, 2, 3})); // 输出: 14
    }
}

