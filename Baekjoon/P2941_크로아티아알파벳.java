import java.io.*;

public class P2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] check = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i = 0; i < check.length; i++) {
            while (str.contains(check[i])) str = str.replace(check[i], "A");
        }
        bw.write(str.length() + "");
        bw.close();
    }
}