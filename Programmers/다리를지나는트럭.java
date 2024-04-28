import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> queue = new LinkedList<>();
            int sumWeight = 0;
            int time = 0;

            for (int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i];

                while (true) {
                    if (queue.isEmpty()) {
                        queue.add(truck);
                        sumWeight += truck;
                        time++;
                        break;
                    } else if (queue.size() == bridge_length) {
                        sumWeight -= queue.poll();
                    } else {
                        if (sumWeight + truck <= weight) {
                            queue.add(truck);
                            sumWeight += truck;
                            time++;
                            break;
                        } else {
                            queue.add(0);
                            time++;
                        }
                    }
                }
            }
            return time + bridge_length;
        }
    }
}