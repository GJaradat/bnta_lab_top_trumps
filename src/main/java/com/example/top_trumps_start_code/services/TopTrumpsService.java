package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.models.Rank;
import com.example.top_trumps_start_code.models.Suit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopTrumpsService {

    private ArrayList<Card> deck;

    public TopTrumpsService() {
    }

    public TopTrumpsService(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public String checkWinner(ArrayList<Card> cards) {
        if (cards.get(0).getCardValue() > cards.get(1).getCardValue()) {
            return cards.get(0).getRank() + " of " + cards.get(0).getSuit() + " wins!";
        } else if (cards.get(0).getCardValue() == cards.get(1).getCardValue()) {
            return String.format("Both players played %ss",cards.get(0).getRank());
        }
        return cards.get(1).getRank() + " of " + cards.get(1).getSuit() + " wins!";
    }

    public void createDeck(){
        this.deck = new ArrayList<Card>();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                this.deck.add(new Card(rank,suit));
            }
        }
    }

    public boolean cardsAreInDeck(ArrayList<Card> cards){
        for (Card card : cards){
            boolean inDeck = false;
            for (Card deckCard : this.deck){
                if ((card.getRank() == (deckCard.getRank())) && (card.getSuit() == (deckCard.getSuit()))){
                    return inDeck = true;
                }
            }
            return false;
        }
        return true;
    }

    public void removePlayedCards(ArrayList<Card> cards){
        for (Card card : cards){
            this.deck.remove(card);
        }
    }




}

