import java.util.Scanner;

public class P2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int gcd = GCD(v1, v2);
        int LCM = v1 * v2 / gcd;
        System.out.println(gcd);
        System.out.println(LCM);
    }

    public static int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }
}