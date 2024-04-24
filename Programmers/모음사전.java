import java.util.ArrayList;

public class 모음사전 {
    static ArrayList<String> al = new ArrayList<>();

    public int solution(String word) {
        String[] dic = {"A", "E", "I", "O", "U"};
        dfs(dic, "", 0);
        int answer = al.indexOf(word) + 1;
        return answer;
    }

    public static void dfs(String[] word, String s, int depth) {
        if (depth >= word.length) {
            return;
        }

        for (int i = 0; i < word.length; i++) {
            al.add(s + word[i]);
            dfs(word, s + word[i], depth + 1);
        }
    }
}
