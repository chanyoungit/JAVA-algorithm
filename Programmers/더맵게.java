import java.util.PriorityQueue;

public class 더맵게 {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        int count = 0;
        while (queue.peek() < K) {

            if (queue.size() < 2) {
                return -1;
            }

            count++;

            int a = queue.poll();
            int b = queue.poll();

            if (a == 0 && b == 0) {
                return -1;
            }

            int c = a + b * 2;

            queue.add(c);
        }

        return count;
    }
}
