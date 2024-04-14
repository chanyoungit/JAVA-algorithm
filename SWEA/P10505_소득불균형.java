import java.io.*;
import java.util.StringTokenizer;

public class P10505_소득불균형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            int sum = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            sum /= N;

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] <= sum) {
                    count++;
                }
            }

            bw.write("#" + test_case + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}