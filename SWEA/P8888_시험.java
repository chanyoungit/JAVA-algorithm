import java.io.*;
import java.util.*;

public class P8888_시험 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= Q; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());    // 참가자 수
            int T = Integer.parseInt(st.nextToken());    // 문제 수
            int P = Integer.parseInt(st.nextToken());    // 참가자 번호

            int[][] arr = new int[N][T];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < T; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] score = new int[T];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    if (arr[i][j] == 0) {
                        score[j]++;
                    }
                }
            }

            int[] grade = new int[N];
            int[] cnt = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < T; j++) {
                    if (arr[i][j] == 1) {
                        grade[i] += score[j];
                        cnt[i]++;
                    }
                }
            }

            int[] rank = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (i == j) {
                        continue;
                    }

                    if (grade[i] < grade[j]) {
                        rank[i]++;
                    } else if (grade[i] == grade[j] && cnt[i] < cnt[j]) {
                        rank[i]++;
                    } else if (grade[i] == grade[j] && cnt[i] == cnt[j] && i > j) {
                        rank[i]++;
                    }
                }
                rank[i]++;
            }

            bw.write("#" + test_case + " " + grade[P - 1] + " " + rank[P - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}