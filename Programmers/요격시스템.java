import java.util.*;

public class 요격시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int answer = 0;
        int num = 0;

        for (int i = 0; i < targets.length; i++) {
            if (num <= targets[i][0]) {
                answer++;
                num = targets[i][1];
            }
        }
        return answer;
    }
}