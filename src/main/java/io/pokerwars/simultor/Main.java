package io.pokerwars.simultor;

import io.pokerwars.StartUpRunner;
import io.pokerwars.bot.model.database.Hands;
import io.pokerwars.bot.model.in.Card;
import io.pokerwars.bot.model.in.Probability;
import io.pokerwars.bot.model.out.Player;
import io.pokerwars.database.HandsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Main {



    private static final Logger LOG =
            (Logger) LoggerFactory.getLogger(Main.class);

    @Autowired HandsRepository handsRepository;

    private List<Hands> handsList = new ArrayList<Hands>();


    public void main(String args[]){

//        Hands hands = new Hands();
//        hands.setCard1R(14);
//        hands.setCard1S(Card.Suit.CLUBS.toString());
//        handsRepository.save(hands);


        Map<Card, Map<Card, Probability>> preFlopAggregator = new HashMap<Card, Map<Card, Probability>>();
        for(int i=0;i<500000000;i++){


            Dealer play = new Dealer();
            List<Player> players =  play.playGame();
            //aggregateResults(players, preFlopAggregator);
            saveResults(players, i);
        }

        //System.out.println("card1 size : " + preFlopAggregator.keySet().size());
//        for(Card card: preFlopAggregator.keySet()){
//
//            //System.out.println("\n\n----------------------------\n\n");
//
//            //System.out.println(card + " -- " + preFlopAggregator.get(card).keySet().size());
//            for(Card card2: preFlopAggregator.get(card).keySet()){
//                Probability probability = preFlopAggregator.get(card).get(card2);
//                System.out.print(String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s", card.getRank(), card.getRank().getValue(),card.getSuit(), card2.getRank(),
//                        card2.getRank().getValue(), card2.getSuit(), probability.getProbability(), probability.getWon(), probability.getPlayed()));
//                System.out.println();
//            }
//        }

    }

    private void saveResults(List<Player> players, Integer gameId){
        for(Player player: players){
            Hands hand = generateHands(player, gameId);
            handsList.add(hand);
        }

        if(handsList.size()>1000){
            System.out.println(gameId);
            handsRepository.saveAll(handsList);
            handsList.clear();
        }
    }

    private Hands generateHands(Player player, Integer gameId){

        Hands hands = new Hands();

        hands.setGameId(gameId);

        hands.setCard1R(player.getPreFlop().get(0).getRank().getValue());
        hands.setCard1S(player.getPreFlop().get(0).getSuit().toString());

        hands.setCard2R(player.getPreFlop().get(1).getRank().getValue());
        hands.setCard2S(player.getPreFlop().get(1).getSuit().toString());

        hands.setCard3R(player.getFlop().get(0).getRank().getValue());
        hands.setCard3S(player.getFlop().get(0).getSuit().toString());

        hands.setCard4R(player.getFlop().get(1).getRank().getValue());
        hands.setCard4S(player.getFlop().get(1).getSuit().toString());

        hands.setCard5R(player.getFlop().get(2).getRank().getValue());
        hands.setCard5S(player.getFlop().get(2).getSuit().toString());

        hands.setCard6R(player.getRiver().getRank().getValue());
        hands.setCard6S(player.getRiver().getSuit().toString());

        hands.setCard7R(player.getTurn().getRank().getValue());
        hands.setCard7S(player.getTurn().getSuit().toString());

        hands.setHandStrength(player.getHandStrength().toString());
        hands.setWon(player.getRank()==1?1:0);

        return hands;

    }

    private void setCardToHand(Card card, Hands hands){


    }

    private static void aggregateResults(List<Player> players, Map<Card, Map<Card, Probability>> preFlopAggregator){

        if(preFlopAggregator==null || players==null){
            return;
        }

        for(Player player: players){
            List<Card> preFlop = player.getPreFlop();
            Card card1 = null;
            Card card2 = null;

            if(preFlop.get(0).compareTo(preFlop.get(1))<0){
                card1 = preFlop.get(0);
                card2 = preFlop.get(1);
            }else {
                card1 = preFlop.get(1);
                card2 = preFlop.get(0);
            }

            if(!preFlopAggregator.containsKey(card1)){
                preFlopAggregator.put(card1, new HashMap<Card, Probability>());
            }

            if(!preFlopAggregator.get(card1).containsKey(card2)){
                Map<Card, Probability> cardProbability = preFlopAggregator.get(card1);
                cardProbability.put(card2, new Probability());
            }

            Probability probability = preFlopAggregator.get(card1).get(card2);
            probability.setPlayed(probability.getPlayed()+1);
            if(player.getRank()==1){
                probability.setWon(probability.getWon()+1);
            }
        }
    }
}
