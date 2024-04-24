import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int t = 0; t < commands.length; t++) {
            int length = commands[t][1] - commands[t][0] + 1;
            int[] arr = new int[length];

            int k = 0;
            for (int i = commands[t][0] - 1; i <= commands[t][1] - 1; i++) {
                arr[k++] = array[i];
            }
            Arrays.sort(arr);

            answer[t] = arr[commands[t][2] - 1];
        }

        return answer;
    }
}
