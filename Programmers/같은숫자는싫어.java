import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                queue.add(arr[i]);
            } else {
                if (arr[i] != arr[i - 1]) {
                    queue.add(arr[i]);
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            answer.add(queue.poll());
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
