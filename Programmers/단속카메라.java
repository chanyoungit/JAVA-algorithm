import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int answer = 0;
        int now = -40000;
        for (int i = 0; i < routes.length; i++) {
            if (now < routes[i][0]) {
                now = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
