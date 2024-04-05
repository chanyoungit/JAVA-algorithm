import java.io.*;
import java.util.StringTokenizer;

public class P17937_큰수의최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            String answer = "1";
            if(A.equals(B)) answer = A;

            int index = i+1;
            bw.write("#" + index + " " + answer +"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}