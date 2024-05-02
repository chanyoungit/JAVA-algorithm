import java.io.*;
import java.util.*;

public class P10993_군주제와공화제 {
    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N + 1][3];
            index = new int[N + 1];
            char[] answer = new char[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[i][0] = a;
                arr[i][1] = b;
                arr[i][2] = c;
                index[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                int m0 = arr[i][0];
                int m1 = arr[i][1];
                int m2 = arr[i][2];
                int cnt = 0;
                int location = -1;

                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }

                    int t0 = arr[j][0];
                    int t1 = arr[j][1];
                    int t2 = arr[j][2];

                    double value = t2 / (Math.pow(t0 - m0, 2) + Math.pow(t1 - m1, 2));
                    if (value > m2) {
                        cnt++;
                        location = j;
                    }
                }

                if (cnt == 0) {
                    answer[i] = 'K';
                } else if (cnt >= 2) {
                    answer[i] = 'D';
                } else {
                    index[i] = location;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (index[i] != i) {
                    find(i);
                    answer[i] = (char) (index[i] + '0');
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case + " ");

            for (int i = 1; i <= N; i++) {
                sb.append(answer[i] + " ");
            }

            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int a) {
        if (index[index[a]] == index[a]) {
            return index[a];
        } else {
            int num = index[a];
            return index[a] = find(num);
        }
    }
}