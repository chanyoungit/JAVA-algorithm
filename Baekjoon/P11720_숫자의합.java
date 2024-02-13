import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();               // 숫자 개수 입력
        String sNum = sc.next();            // 숫자 입력
        char[] cNum = sNum.toCharArray();   // sNum을 char[]형 변수로 변환하여 cNum에 저장

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += cNum[i] - 48;              // 아스키 코드를 이용하여 문자를 정수로 변환
        }
        System.out.println(sum);
    }
}
