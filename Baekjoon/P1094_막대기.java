import java.io.*;

public class P1094_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < 7; i++) {
            if ((X & (1 << i)) > 0) count++;
        }

        /* 비트 마스킹 X
        int stick = 64;
        while (X > 0) {
            if (stick > X) stick /=2;
            else {
                X -= stick;
                count++;
            }
        }
         */

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
