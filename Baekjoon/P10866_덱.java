import java.io.*;
import java.util.*;

class P10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();

        int num;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {

                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;

                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;

                case "pop_front":
                    bw.write((deque.isEmpty() ? -1 : deque.removeFirst()) + "\n");
                    break;

                case "pop_back":
                    bw.write((deque.isEmpty() ? -1 : deque.removeLast()) + "\n");
                    break;

                case "size":
                    bw.write(deque.size() + "\n");
                    break;

                case "empty":
                    bw.write((deque.isEmpty() ? 1 : 0) + "\n");
                    break;

                case "front":
                    bw.write((deque.isEmpty() ? -1 : deque.peekFirst()) + "\n");
                    break;

                case "back":
                    bw.write((deque.isEmpty() ? -1 : deque.peekLast()) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}