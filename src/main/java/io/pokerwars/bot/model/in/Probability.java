package io.pokerwars.bot.model.in;

public class Probability {

    private Integer played=0;
    private Integer won=0;

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Double getProbability() {
        return (won*1.0)/played;
    }

    @Override
    public String toString() {
        return "Probability{" +
                "played=" + played +
                ", won=" + won +
                ", probability=" + (won*1.0)/played +
                '}';
    }
}
