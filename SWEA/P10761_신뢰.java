import java.io.*;
import java.util.StringTokenizer;

public class P10761_신뢰 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int indexB = 1;
            int indexO = 1;

            int sum = 0;
            int leftTime_B = 0;
            int leftTime_O = 0;

            for (int i = 0; i < N; i++) {
                String str = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (str.equals("B")) {
                    int gap = (int) Math.abs(number - indexB);
                    if (gap == 0) {
                        sum += 1;
                        leftTime_O += 1;
                        leftTime_B = 0;
                    } else {
                        if (gap <= leftTime_B) {
                            sum += 1;
                            leftTime_O += 1;
                            leftTime_B = 0;
                            indexB = number;
                        } else {
                            sum += Math.abs(gap - leftTime_B) + 1;
                            leftTime_O += Math.abs(gap - leftTime_B) + 1;
                            leftTime_B = 0;
                            indexB = number;
                        }
                    }
                } else if (str.equals("O")) {
                    int gap = (int) Math.abs(number - indexO);
                    if (gap == 0) {
                        sum += 1;
                        leftTime_B += 1;
                        leftTime_O = 0;
                    } else {
                        if (gap <= leftTime_O) {
                            sum += 1;
                            leftTime_B += 1;
                            leftTime_O = 0;
                            indexO = number;
                        } else {
                            sum += Math.abs(gap - leftTime_O) + 1;
                            leftTime_B += Math.abs(gap - leftTime_O) + 1;
                            leftTime_O = 0;
                            indexO = number;
                        }
                    }
                }
            }
            bw.write("#" + test_case + " " + sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}