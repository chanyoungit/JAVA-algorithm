import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13428_숫자조작 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            char[] arr = br.readLine().toCharArray();
            char[] arrMin = Arrays.copyOf(arr, arr.length);
            char[] arrMax = Arrays.copyOf(arr, arr.length);

            searchMin(arrMin);

            sb.append("#" + test_case + " ");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arrMin[i]);
            }
            sb.append(" ");

            searchMax(arrMax);

            for (int i = 0; i < arr.length; i++) {
                sb.append(arrMax[i]);
            }
            bw.write(sb.toString() + "\n");
            sb.setLength(0);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void searchMin(char[] arr) {
        int changeMin = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    if (i == 0 && arr[j] == '0') {
                        continue;
                    }
                    changeMin = i;
                    break;
                }
            }
            if (changeMin != -1)
                break;
        }

        if (changeMin != -1) {
            int indexMin = changeMin;
            for (int i = changeMin + 1; i < arr.length; i++) {
                if (arr[indexMin] >= arr[i]) {
                    if (changeMin == 0 && arr[i] == '0')
                        continue;
                    indexMin = i;
                }
            }

            char temp = arr[indexMin];
            arr[indexMin] = arr[changeMin];
            arr[changeMin] = temp;
            return;
        } else
            return;
    }

    public static void searchMax(char[] arr) {
        int changeMax = -1;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    changeMax = i;
                    break;
                }
            }
            if (changeMax != -1)
                break;

        }

        if (changeMax != -1) {
            int indexMax = changeMax;
            for (int i = indexMax + 1; i < arr.length; i++) {
                if (arr[indexMax] <= arr[i])
                    indexMax = i;
            }

            char temp = arr[indexMax];
            arr[indexMax] = arr[changeMax];
            arr[changeMax] = temp;
            return;
        } else
            return;
    }
}