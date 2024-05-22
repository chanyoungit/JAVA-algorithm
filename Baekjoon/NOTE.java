import java.io.*;
import java.util.*;

class NOTE {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        int N = sc.nextInt();
        sc.nextLine();

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        for (int i=0; i<N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(sc.nextLine());
        for (int i=0; i<N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("T = " + T);
        System.out.println("N = " + N);
        System.out.println("arr1 = ");
        for (int i=0; i<N; i++) {
            System.out.printf("%d" , arr1[i]);
        }
        System.out.println();
        System.out.println("arr2 = ");
        for (int i=0; i<N; i++) {
            System.out.printf("%d" , arr2[i]);
        }
    }
}