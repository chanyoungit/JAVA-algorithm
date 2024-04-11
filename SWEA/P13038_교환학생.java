import java.io.*;
import java.util.StringTokenizer;

public class P13038_교환학생 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            arr = new int[7];

            n = Integer.parseInt(br.readLine()); // 총 들어야하는 수업 횟수
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++) {
                min = Math.min(min, DayCnt(i));
            }
            bw.write("#" + test_case + " " + min + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int DayCnt(int Day) {
        int cnt = 0;
        int DayCnt = 0;
        while (cnt != n) {
            DayCnt++;
            if (arr[Day] == 1) {
                cnt++;
            }
            Day++;
            if (Day == 7) {
                Day = 0;
            }
        }
        return DayCnt;
    }
}