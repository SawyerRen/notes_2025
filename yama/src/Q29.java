import java.util.Arrays;

public class Q29 {
    public static int findMaximumNum(int[] answered, int[] needed, int q) {
        int res = 0;
        int[] req = new int[answered.length];

        for (int i = 0; i < answered.length; i++) {
            req[i] = Math.max(needed[i] - answered[i], 0);
        }

        Arrays.sort(req);

        for (int r : req) {
            if (r == 0) {
                res++;
            } else {
                if (q >= r) {
                    res++;
                    q -= r;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumNum(new int[]{24, 27, 0}, new int[]{51, 52, 100}, 100)); // 2
        System.out.println(findMaximumNum(new int[]{24, 27, 0}, new int[]{51, 52, 100}, 200)); // 3
        System.out.println(findMaximumNum(new int[]{2, 4}, new int[]{4, 5}, 1)); // 1
    }
}
