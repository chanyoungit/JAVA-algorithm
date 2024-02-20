import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queueInt = new PriorityQueue<>((o1, o2) -> {
            int abs_o1 = Math.abs(o1);
            int abs_o2 = Math.abs(o2);
            if (abs_o1 == abs_o2) return o1 > o2 ? 1 : -1;
            return abs_o1 - abs_o2;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (queueInt.isEmpty()) sb.append("0\n");
                else sb.append(queueInt.poll()).append("\n");
            } else {
                queueInt.add(num);
            }
        }
        System.out.println(sb);
    }
}