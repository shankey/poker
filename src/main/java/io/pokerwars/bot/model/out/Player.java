package io.pokerwars.bot.model.out;

import io.pokerwars.bot.model.in.Card;
import io.pokerwars.bot.strategies.HandStrength;
import io.pokerwars.bot.strategies.PlayerHand;
import io.pokerwars.simultor.Table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player implements Comparable<Player> {

  private String username;
  private PlayerHand playerHand = new PlayerHand();
  private List<Card> preFlop = new ArrayList<Card>();
  private List<Card> flop = new ArrayList<Card>();
  private Card river;
  private Card turn;
  private HandStrength handStrength;
  private Integer rank;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public HandStrength getHandStrength() {
    return handStrength;
  }

  public void setHandStrength(HandStrength handStrength) {
    this.handStrength = handStrength;
  }

  public PlayerHand getPlayerHand() {
    return playerHand;
  }

  public void setPlayerHand(PlayerHand playerHand) {
    this.playerHand = playerHand;
  }

  public List<Card> getPreFlop() {
    return preFlop;
  }

  public void setPreFlop(List<Card> preFlop) {
    this.preFlop = preFlop;
  }

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public List<Card> getFlop() {
    return flop;
  }

  public void setFlop(List<Card> flop) {
    this.flop = flop;
  }

  public Card getRiver() {
    return river;
  }

  public void setRiver(Card river) {
    this.river = river;
  }

  public Card getTurn() {
    return turn;
  }

  public void setTurn(Card turn) {
    this.turn = turn;
  }

  @Override
  public int compareTo(Player o) {
    return this.getHandStrength().compareHandStrength(this, o);
  }

  @Override
  public String toString() {
    return String.format("Player %s: %s %s %s\n", getUsername(), getPreFlop(), getHandStrength(), getRank());
  }


}
