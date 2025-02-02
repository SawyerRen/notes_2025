import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q36 {
    public static int[][] findOverlappingTimes(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i + 1 < intervals.length && intervals[i + 1][0] <= end){//下一个是i + 1
                end = Math.max(intervals[i + 1][1], end);
                i++;
            }
            res.add(new int[]{start, end});//不能新建Newend
        }

        int size = res.size();

        int[][] finalres = new int[size][2];
        for(int i = 0 ; i < size; i++){
            finalres[i] = res.get(i);
        }

        return finalres;
    }

    public static void main(String[] args) {
        int[][] intervals = {{7, 7}, {2, 3}, {6, 11}, {1, 2}};
        System.out.println(Arrays.deepToString(findOverlappingTimes(intervals))); // [[1, 3], [6, 11]]
    }
}
