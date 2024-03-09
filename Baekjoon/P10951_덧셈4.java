import java.io.*;
import java.util.StringTokenizer;

public class P10951_덧셈4 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            StringTokenizer st;
            String str;
            while ((str = br.readLine()) != null) {
                st = new StringTokenizer(str);
                if (st.hasMoreTokens()) {
                    bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
                } else break;
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}