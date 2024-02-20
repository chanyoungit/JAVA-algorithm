import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queueInt = new LinkedList<>();
        for (int i = 1; i <= N; i++) queueInt.add(i);
        while (true) {
            if (queueInt.size() == 1) {
                System.out.println(queueInt.poll());
                break;
            }
            queueInt.poll();
            queueInt.add(queueInt.poll());
        }
    }
}