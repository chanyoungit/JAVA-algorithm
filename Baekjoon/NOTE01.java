import java.io.*;
import java.util.StringTokenizer;

public class NOTE01 {
    static int N;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int LIS = 0;
        for (int i = 0; i < N; i++) {
            int idx = BinarySearch(A[i], 0, LIS, LIS + 1);

            if (idx == -1) {
                dp[LIS++] = A[i];
            } else {
                dp[idx] = A[i];
            }

            for (int t = 0; t < N; t++) System.out.printf("%d ",dp[t]);
            System.out.println();
        }

        bw.write(LIS + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int BinarySearch(int num, int start, int end, int size) {
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num <= dp[mid]) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start == size) {
            return -1;
        } else {
            return res;
        }
    }
}