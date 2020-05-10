package io.pokerwars.bot.model.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class Deck {

    private List<Card> deck = new ArrayList<Card>();

    public Deck() {

        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Rank rank: Card.Rank.values()){
                Card card = new Card();
                card.setRank(rank);
                card.setSuit(suit);

                deck.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card pop(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public void printDeck(){
        for(Card card: deck){
            System.out.println(card);
        }
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }


}
