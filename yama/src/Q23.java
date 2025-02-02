public class Q23 {
    public static long getMinimumOperations(int[] cart) {
        long res = 0;
        int diff = 0;
        for (int i = cart.length - 1; i >= 0; i--) {
            int operationCount = -cart[i] - diff;
            res += Math.abs(operationCount);
            diff += operationCount;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumOperations(new int[]{3, 2, 1}));
        System.out.println(getMinimumOperations(new int[]{3, 2, 0, 0, -1}));
        System.out.println(getMinimumOperations(new int[]{-1, -1, -1, -1}));
    }
}
