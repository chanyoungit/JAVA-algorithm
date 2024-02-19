import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(num++);
        }
        int size = queue.size();
        int cycle = 1;
        while (size != 1) {
            if (cycle % 2 == 1) {
                queue.poll();
                cycle++;
                size--;
            } else {
                int pollNum = queue.poll();
                queue.add(pollNum);
                cycle++;
            }
        }
        int Q = queue.peek();
        System.out.println(Q);
    }
}
