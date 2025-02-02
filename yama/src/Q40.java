public class Q40 {
    // my solution
    public static int solution2(String serverType) {
        char[] servers = serverType.toCharArray();
        int n = servers.length;
        Character c = null;
        int res = 0;
        for (char server : servers) {
            if (server == '?') continue;
            if (c == null) {
                c = server;
            } else {
                if (server != c) {
                    res++;
                    c = server;
                }
            }
        }
        return res;
    }

    // llm
    public static int findMinimumInefficiency(String serverType) {
        char[] servers = serverType.toCharArray();
        int n = servers.length;

        // Step 1: 从左到右填充 '?' 使其尽量接近左侧字符
        for (int i = 1; i < n; i++) {
            if (servers[i] == '?' && servers[i - 1] != '?') {
                servers[i] = servers[i - 1];
            }
        }

        // Step 2: 从右到左填充 '?' 使其尽量接近右侧字符
        for (int i = n - 2; i >= 0; i--) {
            if (servers[i] == '?' && servers[i + 1] != '?') {
                servers[i] = servers[i + 1];
            }
        }

        // Step 3: 计算 inefficiency（相邻不同的服务器对数）
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (servers[i] != servers[i - 1]) {
                res++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(findMinimumInefficiency("??011??0")); // 输出: 2
        System.out.println(findMinimumInefficiency("00?10??1?")); // 输出: 2
        System.out.println(solution2("??011??0")); // 输出: 2
        System.out.println(solution2("00?10??1?")); // 输出: 3
    }
}
