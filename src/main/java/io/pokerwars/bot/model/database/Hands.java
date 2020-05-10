package io.pokerwars.bot.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hands {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer gameId;

    private Integer card1R;
    private String card1S;

    private Integer card2R;
    private String card2S;

    private Integer card3R;
    private String card3S;

    private Integer card4R;
    private String card4S;

    private Integer card5R;
    private String card5S;

    private Integer card6R;
    private String card6S;

    private Integer card7R;
    private String card7S;

    private Integer won;
    private String handStrength;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getCard1R() {
        return card1R;
    }

    public void setCard1R(Integer card1R) {
        this.card1R = card1R;
    }

    public String getCard1S() {
        return card1S;
    }

    public void setCard1S(String card1S) {
        this.card1S = card1S;
    }

    public Integer getCard2R() {
        return card2R;
    }

    public void setCard2R(Integer card2R) {
        this.card2R = card2R;
    }

    public String getCard2S() {
        return card2S;
    }

    public void setCard2S(String card2S) {
        this.card2S = card2S;
    }

    public Integer getCard3R() {
        return card3R;
    }

    public void setCard3R(Integer card3R) {
        this.card3R = card3R;
    }

    public String getCard3S() {
        return card3S;
    }

    public void setCard3S(String card3S) {
        this.card3S = card3S;
    }

    public Integer getCard4R() {
        return card4R;
    }

    public void setCard4R(Integer card4R) {
        this.card4R = card4R;
    }

    public String getCard4S() {
        return card4S;
    }

    public void setCard4S(String card4S) {
        this.card4S = card4S;
    }

    public Integer getCard5R() {
        return card5R;
    }

    public void setCard5R(Integer card5R) {
        this.card5R = card5R;
    }

    public String getCard5S() {
        return card5S;
    }

    public void setCard5S(String card5S) {
        this.card5S = card5S;
    }

    public Integer getCard6R() {
        return card6R;
    }

    public void setCard6R(Integer card6R) {
        this.card6R = card6R;
    }

    public String getCard6S() {
        return card6S;
    }

    public void setCard6S(String card6S) {
        this.card6S = card6S;
    }

    public Integer getCard7R() {
        return card7R;
    }

    public void setCard7R(Integer card7R) {
        this.card7R = card7R;
    }

    public String getCard7S() {
        return card7S;
    }

    public void setCard7S(String card7S) {
        this.card7S = card7S;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public String getHandStrength() {
        return handStrength;
    }

    public void setHandStrength(String handStrength) {
        this.handStrength = handStrength;
    }

    @Override
    public String toString() {
        return "Hands{" +
                "id=" + id +
                ", gameId=" + gameId +
                ", card1R=" + card1R +
                ", card1S='" + card1S + '\'' +
                ", card2R=" + card2R +
                ", card2S='" + card2S + '\'' +
                ", card3R=" + card3R +
                ", card3S='" + card3S + '\'' +
                ", card4R=" + card4R +
                ", card4S='" + card4S + '\'' +
                ", card5R=" + card5R +
                ", card5S='" + card5S + '\'' +
                ", card6R=" + card6R +
                ", card6S='" + card6S + '\'' +
                ", card7R=" + card7R +
                ", card7S='" + card7S + '\'' +
                ", won=" + won +
                ", handStrength='" + handStrength + '\'' +
                '}';
    }
}
