import java.io.*;
import java.util.PriorityQueue;

//public class P11653_소인수분해 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//        for (int i = 2; i < N; i++) {
//            while (N % i == 0) {
//                sb.append(i).append("\n");
//                N /= i;
//            }
//        }
//        if (N != 1) sb.append(N).append("\n");
//        System.out.println(sb);
//    }
//}

public class P11653_소인수분해 {
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        if (N != 1) {
            so(N);
            while (!queue.isEmpty()) {
                bw.write(queue.poll() + "\n");
            }
        }

        bw.close();
    }

    public static void so(int a) {
        boolean bl = true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                bl = false;
                queue.add(i);
                int b = a / i;
                so(b);
                break;
            }
        }
        if (bl) {
            queue.add(a);
        }
    }
}