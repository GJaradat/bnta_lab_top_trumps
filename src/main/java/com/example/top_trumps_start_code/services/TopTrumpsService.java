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
            return String.format("%s of %s wins!", cards.get(0).getRank(), cards.get(0).getSuit());
        } else if (cards.get(0).getCardValue() == cards.get(1).getCardValue()) {
            return String.format("Both players played %sS. This is a draw!", cards.get(0).getRank());
        }
        return String.format("%s of %s wins!", cards.get(1).getRank(), cards.get(1).getSuit());
    }

    public void createDeck() {
        this.deck = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.deck.add(new Card(rank, suit));
            }
        }
    }

    public boolean cardsAreInDeck(ArrayList<Card> cards) {
        ArrayList<Boolean> cardsMatch = new ArrayList<>();
        for (Card card : cards) {
            for (Card deckCard : this.deck) {
                if ((card.getRank() == (deckCard.getRank())) && (card.getSuit() == (deckCard.getSuit()))) {
                    cardsMatch.add(true);
                }
            }
        }
        return cardsMatch.size() == cards.size();
    }


    public void removePlayedCards(ArrayList<Card> cards) {
        for (Card card : cards) {
            this.deck.removeIf(deckCard -> (card.getRank() == (deckCard.getRank())) && (card.getSuit() == (deckCard.getSuit())));
        }
    }
}
