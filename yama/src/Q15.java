import java.util.ArrayList;
import java.util.List;

public class Q15 {
    public static String findNumber(List<Integer> nums) {
        if (nums.size() == 2) {
            return "" + nums.get(0) + nums.get(1);
        }
        List<Integer> res = new ArrayList<>(nums);
        while (res.size() > 2) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < res.size() - 1; i++) {
                int n = (res.get(i) + res.get(i + 1)) % 10;
                next.add(n);
            }
            res = next;
        }
        return "" + res.get(0) + res.get(1);
    }

    // 测试样例
    public static void main(String[] args) {
        System.out.println(findNumber(List.of(1, 2, 3, 4))); // 输出："82"
        System.out.println(findNumber(List.of(5, 6)));       // 输出："56"
        System.out.println(findNumber(List.of(4, 5, 6, 7)));       // 输出："56"
    }
}
