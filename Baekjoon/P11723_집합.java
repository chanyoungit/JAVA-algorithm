import java.io.*;
import java.util.StringTokenizer;

public class P11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int S = 0;
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("all")) S = (1 << 21) - 1;
            else if (str.equals("empty")) S = 0;
            else {
                int num = Integer.parseInt(st.nextToken());
                switch (str) {
                    case "add":
                        S = S | (1 << num);
                        break;
                    case "remove":
                        S = S & ~(1 << num);
                        break;
                    case "check":
                        bw.write(((S & (1 << num)) != 0 ? 1 : 0) + "\n");
                        break;
                    case "toggle":
                        S = S ^ (1 << num);
                        break;
                }
            }
        }
        bw.close();
    }
}
