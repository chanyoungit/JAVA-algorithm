import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (str.equals("I")) {
                queue.add(num);
            } else if (str.equals("D") && num == 1) {
                if (queue.size() == 0) {
                    continue;
                }
                queue.poll();
            } else {
                if (queue.size() == 0) {
                    continue;
                }
                ArrayList<Integer> al = new ArrayList<>();
                while (!queue.isEmpty()) {
                    al.add(queue.poll());
                }
                al.remove(al.size() - 1);
                for (int j = 0; j < al.size(); j++) {
                    queue.add(al.get(j));
                }
            }
        }


        ArrayList<Integer> al = new ArrayList<>();
        while (!queue.isEmpty()) {
            al.add(queue.poll());
        }

        int[] answer = new int[2];

        if (al.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        } else if (al.size() == 1) {
            answer[0] = al.get(0);
            answer[1] = 0;
        } else {
            answer[0] = al.get(0);
            answer[1] = al.get(al.size() - 1);
        }

        return answer;
    }
}
