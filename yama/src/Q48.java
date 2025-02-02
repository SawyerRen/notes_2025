public class Q48 {
    public static int getLongestMatch2(String text, String regex) {
        int starIndex = regex.indexOf('*');
        String prefix = regex.substring(0, starIndex);
        String suffix = regex.substring(starIndex + 1);

        int maxLen = -1;
        int n = text.length();
        int prefixLen = prefix.length();
        int suffixLen = suffix.length();

        for (int i = 0; i <= n - prefixLen; i++) {
            if (text.startsWith(prefix, i)) {
                int start = i + prefixLen;
                for (int j = start; j <= n - suffixLen; j++) {
                    if (text.startsWith(suffix, j)) {
                        int end = j + suffixLen;
                        int len = end - i;
                        if (len > maxLen) {
                            maxLen = len;
                        }
                    }
                }
            }
        }

        return maxLen;
    }

    public static int getLongestMatch(String text, String regex) {
        int index = regex.indexOf('*');
        if (index == -1) return -1; // 不可能匹配

        String prefix = regex.substring(0, index);
        String suffix = regex.substring(index + 1);
        int res = -1;

        int n = text.length(), prefixLen = prefix.length(), suffixLen = suffix.length();

        // 在 text 中查找所有可能的 prefix 开头的位置
        for (int i = 0; i <= n - prefixLen; i++) {
            if (!text.startsWith(prefix, i)) continue; // 不是有效前缀，跳过

            // 从 prefix 开始的位置，向后搜索 suffix
            for (int j = i + prefixLen; j <= n; j++) {
                if (j >= suffixLen && text.startsWith(suffix, j - suffixLen)) {
                    res = Math.max(res, j - i); // 更新最大匹配长度
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(getLongestMatch("hackerrank", "ack*r"));  // 输出: 6
        System.out.println(getLongestMatch("programming", "r*in"));  // 输出: 9
        System.out.println(getLongestMatch("debug", "ug*eb"));       // 输出: -1
        System.out.println(getLongestMatch2("hackerrank", "ack*r"));  // 输出: 6
        System.out.println(getLongestMatch2("programming", "r*in"));  // 输出: 9
        System.out.println(getLongestMatch2("debug", "ug*eb"));       // 输出: -1
    }


}
