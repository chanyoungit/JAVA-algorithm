import java.io.*;
import java.util.StringTokenizer;

public class P18662_등차수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int index = i + 1;

            int gap1 = b - a;
            int gap2 = c - b;


            if (gap1 == gap2)
                sb.append("#" + index + " 0.0");
            else {
                float x = (Math.abs(gap2 - gap1) / (float) 2);
                sb.append("#" + index + " " + x);
            }

            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}