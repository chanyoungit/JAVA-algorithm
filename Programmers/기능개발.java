import java.util.ArrayList;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int index = 0;

        while (index < progresses.length) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            if (progresses[index] >= 100) {
                int count = 1;
                for (int i = index + 1; i < progresses.length; i++) {
                    if (progresses[i] < 100) {
                        break;
                    }
                    count++;
                }
                index += count;
                answer.add(count);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
