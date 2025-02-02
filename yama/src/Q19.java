public class Q19 {
    public static long getDataDependenceSum(long n) {
        int sqrtN = (int) Math.sqrt(n);
        long sum = 0;

        // 累加 sum_a: 对于每个 div 从 1 到 sqrtN，累加 n / div
        for (int div = 1; div <= sqrtN; div++) {
            sum += n / div;
        }

        // 计算 maxQ = n / sqrtN，并累加满足条件的 x 值
        long maxQ = n / sqrtN;
        for (int x = 1; x <= maxQ; x++) {
            if (n / x > sqrtN) {
                sum += x;
            }
        }

        return sum;
    }

    // 测试代码
    public static void main(String[] args) {
        System.out.println(getDataDependenceSum(13));
        System.out.println(getDataDependenceSum(1));
        System.out.println(getDataDependenceSum(5));
    }
}
