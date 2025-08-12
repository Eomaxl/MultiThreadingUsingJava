package game_leaderboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@AllArgsConstructor
public class Player implements Comparable<Player> {

    private String id;

    @Setter
    private Integer totalScore;

    @Override
    public int compareTo(Player o) {
        return o.totalScore.compareTo(this.totalScore);
    }

    @Override
    public String toString() {
        return getId() + ": " + getTotalScore();
    }

}