import java.util.*;
import java.util.Map.Entry;

public class 달리기경주 {

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String player : callings) {
            int nowRank = map.get(player);

            String frontPlayer = players[nowRank - 1];
            map.replace(frontPlayer, nowRank);
            players[nowRank] = frontPlayer;

            map.replace(player, nowRank - 1);
            players[nowRank - 1] = player;
        }

        return players;
    }
}