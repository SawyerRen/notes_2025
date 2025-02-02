public class Q27 {
    public static int getMaximumGreyness(String[] pixels) {
        int m = pixels.length, n = pixels[0].length();
        int[] rowDiff = new int[m];
        int[] colDiff = new int[n];

        // Compute the differences for each row and column.
        // For each pixel, add +1 if it's '1' (black) and -1 if it's '0' (white).
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = pixels[i].charAt(j) == '1' ? 1 : -1;
                rowDiff[i] += diff;
                colDiff[j] += diff;
            }
        }

        // Find the maximum difference among rows and among columns.
        int maxRowDiff = Integer.MIN_VALUE, maxColDiff = Integer.MIN_VALUE;
        for (int diff : rowDiff) {
            maxRowDiff = Math.max(maxRowDiff, diff);
        }
        for (int diff : colDiff) {
            maxColDiff = Math.max(maxColDiff, diff);
        }

        // The maximum grayness is the sum of the maximum row difference and the maximum column difference.
        return maxRowDiff + maxColDiff;
    }

    public static int getMaximumGreyness2(String[] pixels) {
        int m = pixels.length;
        if (m == 0) return 0;
        int n = pixels[0].length();

        int maxRow = 0;          // 记录每行中 '1' 的最大数量
        int[] colOnes = new int[n]; // 记录每列中 '1' 的数量

        // 同时计算每行和每列的 '1' 数量
        for (String pixel : pixels) {
            int rowCount = 0;
            for (int j = 0; j < n; j++) {
                if (pixel.charAt(j) == '1') {
                    rowCount++;
                    colOnes[j]++;
                }
            }
            maxRow = Math.max(maxRow, rowCount);
        }

        int maxCol = 0;
        for (int count : colOnes) {
            maxCol = Math.max(maxCol, count);
        }

        // 根据题目公式计算最大灰度值：
        // max_greyness = 2 * (max_row_ones + max_col_ones) - (m + n)
//        return 2 * (maxRow + maxCol) - (n + m);
        return (maxRow - (m - maxRow)) + (maxCol - (n - maxCol));
    }

    public static void main(String[] args) {
        System.out.println(getMaximumGreyness(new String[]{"1010", "0101", "1010"}));
        System.out.println(getMaximumGreyness(new String[]{"011", "101", "001"}));
        System.out.println(getMaximumGreyness(new String[]{"101", "001", "110"}));
        System.out.println(getMaximumGreyness(new String[]{"001", "001", "000"}));
        System.out.println(getMaximumGreyness2(new String[]{"1010", "0101", "1010"}));
        System.out.println(getMaximumGreyness2(new String[]{"011", "101", "001"}));
        System.out.println(getMaximumGreyness2(new String[]{"101", "001", "110"}));
        System.out.println(getMaximumGreyness2(new String[]{"001", "001", "000"}));
    }
}
