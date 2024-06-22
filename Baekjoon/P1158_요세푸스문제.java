import java.io.*;
import java.util.*;

class P1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            for (int i=1; i<K; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll());

//        int cnt = 1;
//        int cnt2 = 0;
//        while (!queue.isEmpty()) {
//            if (cnt % K == 0) {
//                cnt2++;
//                if (cnt2 == N) {
//                    sb.append(queue.poll());
//                } else {
//                    sb.append(queue.poll() + ", ");
//                }
//            } else {
//                queue.add(queue.poll());
//            }
//            cnt++;
//        }

        sb.append(">");
        bw.write(sb.toString() + "");

        bw.flush();
        bw.close();
        br.close();
    }
}