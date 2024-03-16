import java.io.*;
import java.util.StringTokenizer;

public class P2042_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 배열 사이즈 구하기
        int k = 0;
        int num = 1;
        while (num < N) {
            num *= 2;
            k++;
        }
        int size = (int) Math.pow(2, k + 1);
        long[] tree = new long[size];

        // 리프 트리 데이터 받기
        for (int i = 0; i < N; i++) {
            Long a = Long.parseLong(br.readLine());
            tree[(int) Math.pow(2, k) + i] = a;
        }

        // 전체 데이터 넣기
        for (int i = tree.length - 1; i > 0; i--) {
            int a = i / 2;
            tree[a] += tree[i];
        }

        // a = 1. 2 인 경우 나누기
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long sum = 0;
            if (a == 1) {
                b += (int) Math.pow(2, k) - 1;
                long gap = c - tree[b];
                while (b > 0) {
                    tree[b] += gap;
                    b /= 2;
                }
            } else {        // a가 2인 경우
                b += (int) Math.pow(2, k) - 1;
                c += (long) Math.pow(2, k) - 1;
                int start = b;
                long end = c;
                while (start <= end) {
                    if (start % 2 == 1) sum += tree[start];
                    if (end % 2 == 0) sum += tree[(int) end];
                    start = (start + 1) / 2;
                    end = (end - 1) / 2;
                }
                bw.write(sum + "\n");
            }
        }
        bw.close();
    }
}