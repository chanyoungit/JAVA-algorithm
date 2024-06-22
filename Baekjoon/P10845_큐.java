import java.io.*;
import java.util.*;

public class P10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int rear = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {

                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    rear = num;
                    break;

                case "pop":
                    if (queue.size() == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(queue.poll() + "\n");
                    }
                    break;

                case "size":
                    bw.write(queue.size() + "\n");
                    break;

                case "empty":
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;

                case "front":
                    bw.write((queue.isEmpty() ? -1 : queue.peek()) + "\n");
                    break;

                case "back":
                    bw.write((queue.isEmpty() ? -1 : rear) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}