import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NOTE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = 10;

        while (M != 0) {
            int a = M & 1;
            System.out.println(a);
            M = M >> 1;
            System.out.println(M);
        }
    }
}