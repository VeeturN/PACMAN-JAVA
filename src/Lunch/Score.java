package Lunch;
import java.io.Serializable;
class Score implements Comparable<Score>,Serializable{
    String name;
    Integer score;

    public Score(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Score other) {
        return other.score.compareTo(this.score);
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}