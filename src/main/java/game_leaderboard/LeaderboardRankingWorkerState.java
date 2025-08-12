package game_leaderboard;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
public class LeaderboardRankingWorkerState {
    public Map<String, Player> playerMap;
    public boolean shouldProcess;
    //    private Queue<Player> queue;
    public List<Player> orderedPlayers;
}


