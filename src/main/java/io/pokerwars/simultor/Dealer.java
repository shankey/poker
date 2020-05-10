package io.pokerwars.simultor;

import io.pokerwars.bot.model.in.Card;
import io.pokerwars.bot.model.in.Deck;
import io.pokerwars.bot.model.in.Probability;
import io.pokerwars.bot.model.out.Player;
import io.pokerwars.bot.strategies.HandStrength;
import io.pokerwars.bot.strategies.PlayerHand;

import java.util.*;

public class Dealer {

    private Deck deck = new Deck();
    private Table table = new Table(6);


    public List<Player> playGame(){
        deal();
        evaluatePlayers();
        //System.out.println(table);

        //System.out.println("-------");
        findWinner();


        return table.getTablePlayers();
    }



    private void evaluatePlayers(){
        List<Player> players = table.getTablePlayers();

        for(Player player: players){

            HandStrength hs = HandStrength.computeHandStrength(player.getPlayerHand());
            player.setHandStrength(hs);
        }
    }


    private void deal(){
        deck.shuffle();
        table.distribute(deck);


    }

    private void findWinner(){
        List<Player> players = table.getTablePlayers();
        Collections.sort(players);
        rankPlayers(players);

    }

    private void rankPlayers(List<Player> players){
        int rank=0;
        Player prevPlayer = null;
        for(Player player: players){
            if(prevPlayer==null){
                rank++;
            }else {
                if(prevPlayer.getHandStrength().compareHandStrength(prevPlayer, player)!=0){
                    rank++;
                }
            }
            player.setRank(rank);
            prevPlayer=player;

        }
    }
}
