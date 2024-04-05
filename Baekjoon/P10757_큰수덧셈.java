import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class P10757_큰수덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());

        bw.write(num1.add(num2) + "\n");
//		bw.write("BigInteger 빼기 : " + num1.subtract(num2) + "\n");
//		bw.write("BigInteger 곱셈 : " + num1.multiply(num2) +"\n");
//		bw.write("BigInteger 나눗셈 : " + num1.divide(num2) +"\n");
//		bw.write("BigInteger 나머지 : " + num1.remainder(num2) +"\n");

        bw.close();
    }

}

