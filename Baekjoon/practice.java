import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class practice {
    static PriorityQueue<Long> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
        so(N);
        while (!queue.isEmpty()) {
            bw.write(queue.poll() + "\n");
        }
        bw.close();
    }

    public static void so(long a) {
        boolean bl = true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                bl = false;
                queue.add((long) i);
                long b = a / i;
                so(b);
                break;
            }
        }
        if (bl) {
            queue.add(a);
        }
    }
}