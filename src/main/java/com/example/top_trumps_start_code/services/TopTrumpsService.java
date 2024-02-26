package com.example.top_trumps_start_code.services;

import com.example.top_trumps_start_code.models.Card;

import java.util.ArrayList;

public class TopTrumpsService {


    public String checkWinner(ArrayList<Card> cards) {
        if (cards.get(0).getCardValue() > cards.get(1).getCardValue()) {
            return cards.get(0).getRank() + " of " + cards.get(0).getSuit() + " wins!";
        } else if (cards.get(0).getCardValue() == cards.get(1).getCardValue()) {
            return "This is a draw.";
        }
        return cards.get(1).getRank() + " of " + cards.get(1).getSuit() + " wins!";
    }

    public TopTrumpsService() {

    }

}

