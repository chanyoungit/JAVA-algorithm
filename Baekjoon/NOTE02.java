import java.io.*;
import java.util.StringTokenizer;

public class NOTE02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int S = 2;
        if( str == "all") {
            S = (1 << 21) - 1;
            System.out.println(S);
        }

    }
}