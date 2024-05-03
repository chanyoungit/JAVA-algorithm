import java.io.*;
import java.util.*;

public class P9611_명진이와동휘의숫자맞추기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= Q; test_case++) {
            int[] visit = new int[10];

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                String str = st.nextToken();

                if (str.equals("NO")) {
                    visit[a] = -1;
                    visit[b] = -1;
                    visit[c] = -1;
                    visit[d] = -1;
                } else if (str.equals("YES")) {
                    if (visit[a] != -1) {
                        visit[a]++;
                    }
                    if (visit[b] != -1) {
                        visit[b]++;
                    }
                    if (visit[c] != -1) {
                        visit[c]++;
                    }
                    if (visit[d] != -1) {
                        visit[d]++;
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < 10; i++) {
                if (visit[max] < visit[i]) {
                    max = i;
                }
            }

            bw.write("#" + test_case + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}