package io.pokerwars.simultor;

import io.pokerwars.bot.model.in.Deck;
import io.pokerwars.bot.model.out.Player;

import java.util.List;

public class Play {

    private Deck deck = new Deck();
    private Table table = new Table(6);

    public void playGame(){
        deal();
        System.out.println(table);

    }

    private void deal(){
        deck.shuffle();
        table.distribute(deck);
    }

    private void findWinner(){

    }
}
