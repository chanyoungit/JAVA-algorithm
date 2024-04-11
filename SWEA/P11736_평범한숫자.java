import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;

public class P11736_평범한숫자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                int count1 = 0;
                int count2 = 0;

                if (arr[i] > arr[i - 1] || arr[i] > arr[i + 1]) {
                    count1++;
                }

                if (arr[i] < arr[i - 1] || arr[i] < arr[i + 1]) {
                    count2++;
                }

                if (count1 == 1 && count2 == 1) {
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