import java.util.TreeSet;

public class Q18 {
    public static String findLongestRegex(String x, String y, String z) {
        if (x == null || y == null || z == null || x.length() != y.length() || x.length() != z.length()) {
            return "-1";
        }
        int n = x.length();
        // 找出所有 z[i] 既不等于 x[i] 也不等于 y[i] 的位置
        int targetIndex = -1;
        for (int i = 0; i < n; i++) {
            if (x.charAt(i) != z.charAt(i) && y.charAt(i) != z.charAt(i)) {
                targetIndex = i; // 记录最后一个不匹配的位置
            }
        }
        if (targetIndex == -1) {
            return "-1";
        }

        StringBuilder builder = new StringBuilder();
        // 预先构造所有大写字母的 TreeSet（自动排序）
        TreeSet<Character> baseSet = new TreeSet<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            baseSet.add(c);
        }

        // 遍历每个位置，构造对应的正则表达式部分
        for (int i = 0; i < n; i++) {
            // 复制一份所有大写字母的集合
            TreeSet<Character> curSet = new TreeSet<>(baseSet);
            // 添加 x 和 y 的字符（注意：可能 x、y 中的字符不是大写字母）
            curSet.add(x.charAt(i));
            curSet.add(y.charAt(i));
            // 在特殊位置移除 z 对应的字符
            if (i == targetIndex) {
                curSet.remove(z.charAt(i));
            }
            if (curSet.isEmpty()) {
                return "-1";
            }
            // 构造当前位置的正则部分，如 "[ABC...]"
            builder.append('[');
            for (char c : curSet) {
                builder.append(c);
            }
            builder.append(']');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(findLongestRegex("AB", "BD", "CD").equals("[ABDEFGHIJKLMNOPQRSTUVWXYZ][ABCDEFGHIJKLMNOPQRSTUVWXYZ]"));
        System.out.println(findLongestRegex("AERB", "ATRC", "AGCB").equals("[ABCDEFGHIJKLMNOPQRSTUVWXYZ][ABCDEFGHIJKLMNOPQRSTUVWXYZ][ABDEFGHIJKLMNOPQRSTUVWXYZ][ABCDEFGHIJKLMNOPQRSTUVWXYZ]"));
        System.out.println(findLongestRegex("ABCD", "CODE", "CODE").equals("-1"));
    }
}
