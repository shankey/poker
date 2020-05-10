package io.pokerwars.simultor;

import io.pokerwars.bot.model.in.Card;
import io.pokerwars.bot.model.in.Deck;
import io.pokerwars.bot.model.out.Player;

import java.util.*;

public class Table {

    private Integer seats;
    List<Player> tablePlayers = new ArrayList<Player>();
    List<Card> tableCards = new ArrayList<>();

    public Table(Integer seats) {
        this.seats = seats;
        for(int i=0;i<seats;i++){
            Player player = new Player();
            player.setUsername("player "+i);
            tablePlayers.add(player);
        }
    }

    public void distribute(Deck deck){

        for(Player player: tablePlayers){
            Card card = deck.pop();
            player.getPreFlop().add(card);
            player.getPlayerHand().getCards().add(card);
        }

        for(Player player: tablePlayers){
            Card card = deck.pop();
            player.getPreFlop().add(card);
            player.getPlayerHand().getCards().add(card);
        }

        deck.pop();

        for(int i=0;i<3;i++){
            Card card = deck.pop();
            tableCards.add(card);
            for(Player player: tablePlayers){
                player.getFlop().add(card);
            }
        }

        Card river = deck.pop();
        tableCards.add(river);
        for(Player player: tablePlayers){
            player.setRiver(river);
        }

        Card turn = deck.pop();
        tableCards.add(deck.pop());
        for(Player player: tablePlayers){
            player.setTurn(turn);
        }

        addTableCardToPlayers();

        for(Player player: tablePlayers){
            Collections.sort(player.getPreFlop());
            Collections.sort(player.getFlop());
        }

    }

    private void addTableCardToPlayers(){
        for(Player player: tablePlayers){
            player.getPlayerHand().getCards().addAll(tableCards);
        }
    }

    public Set<Card> getTableCardsAsSet(){
        Set<Card> tableCardsSet = new HashSet<Card>(tableCards);
        return tableCardsSet;

    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public List<Player> getTablePlayers() {
        return tablePlayers;
    }

    public void setTablePlayers(List<Player> tablePlayers) {
        this.tablePlayers = tablePlayers;
    }

    @Override
    public String toString() {
        return "Table {\n" +

                ", tablePlayers=\n" + tablePlayers +
                ", tableCards=\n" + tableCards +
                "\n}";
    }
}
