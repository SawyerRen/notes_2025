import java.util.*;

public class Q17 {
    public static int getOutlierValue(int[] arr) {
        int totalSum = 0;
        for (int n : arr) {
            totalSum += n;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int res = Integer.MIN_VALUE;
        for (int x : arr) {
            int remainder = totalSum - x;
            if (remainder % 2 != 0) continue;

            int target = remainder / 2;
            if (freq.containsKey(target)) {
                if (target == x && freq.get(target) >= 2) {
                    res = Math.max(res, x);
                } else if (target != x) {
                    res = Math.max(res, x);
                }
            }
        }
        return res;
    }

    // 测试样例
    public static void main(String[] args) {
        System.out.println(getOutlierValue(new int[]{1, 2, 3, 4}));  // 输出 4
        System.out.println(getOutlierValue(new int[]{2, 2, 4, 6}));  // 输出 6
        System.out.println(getOutlierValue(new int[]{4, 1, 3, 16, 2, 10}));
        System.out.println(getOutlierValue(new int[]{4, 1, 2, 1, 10, 3}));
    }
}
