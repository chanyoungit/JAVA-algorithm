import java.util.Scanner;

public class P2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) num[i] = sc.nextInt();

//      삽입정렬
        int key;
        for (int i=1; i<N; i++){
            int j;
            key = num[i];
            for (j=i-1; j>=0; j--){
                if(num[j] > key)
                    num[j+1] = num[j];
                else break;
                num[j] = key;
            }
        }
        for (int i=0; i<N; i++)
            System.out.println(num[i]);

//       버블정렬
//        for (int j = 0; j < N - 1; j++) {
//            int swap = 0;
//            for (int i = 0; i < N - 1 - j; i++) {
//                if (num[i] > num[i + 1]) {
//                    int hap = num[i + 1];
//                    num[i + 1] = num[i];
//                    num[i] = hap;
//                    swap++;
//                }
//            }
//            if (swap == 0) break;
//        }
//        for (int i = 0; i < N; i++) System.out.println(num[i]);
    }
}