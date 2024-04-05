import java.io.*;
import java.math.*;
import java.util.StringTokenizer;

public class BigInteger_study {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());

            String result = GCD(A, B);

            int index = i + 1;
            bw.write("#" + index + " " + result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String GCD(BigInteger a, BigInteger b) {
        BigInteger zero = new BigInteger("0");
        if (a.remainder(b).compareTo(zero) == 0) {
            String str = b.toString();
            return str;
        } else {
            return GCD(b, a.remainder(b));
        }
    }
}

//BigInteger num1 = new BigInteger(st.nextToken());
//BigInteger num2 = new BigInteger(st.nextToken());
//
//		bw.write(num1.add(num2) + "\n");
//		bw.write("BigInteger 빼기 : " + num1.subtract(num2) + "\n");
//		bw.write("BigInteger 곱셈 : " + num1.multiply(num2) +"\n");
//		bw.write("BigInteger 나눗셈 : " + num1.divide(num2) +"\n");
//		bw.write("BigInteger 나머지 : " + num1.remainder(num2) +"\n");