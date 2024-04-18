import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int count = 0;
        int nowTime = 0;
        int answer = 0;
        int index = 0;

        while (count < jobs.length) {

            while (index < jobs.length && jobs[index][0] <= nowTime) {
                queue.add(jobs[index++]);
            }

            if (queue.isEmpty()) {
                nowTime = jobs[index][0];
            } else {
                int[] time = queue.poll();
                answer += time[1] + nowTime - time[0];
                nowTime += time[1];
                count++;
            }
        }
        answer /= jobs.length;
        return answer;
    }
}
