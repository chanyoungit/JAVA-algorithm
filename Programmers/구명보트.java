import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int index = 0;

        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
                answer++;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
