package com.example.top_trumps_start_code.controllers;


import com.example.top_trumps_start_code.models.*;
import com.example.top_trumps_start_code.services.TopTrumpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/toptrumps")
public class TopTrumpsController {


    @Autowired
    TopTrumpsService service;

    @PostMapping
    public ResponseEntity<Reply> newGame(){
        service.createDeck();
        return new ResponseEntity<>(new Reply("Started a new game"), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Reply> newRound(@RequestBody ArrayList<Card> cards){
        // play if cards are in deck
        if (service.cardsAreInDeck(cards)) {
            //remove cards from deck
            service.removePlayedCards(cards);

            //check who's the winner
            Reply reply = new Reply(service.checkWinner(cards));
            return new ResponseEntity<>(reply, HttpStatus.ACCEPTED);
        }
        //if cards are not in the deck
        return new ResponseEntity<>(new Reply(String.format("This card has already been played! Current deck size: %d",service.getDeck().size())), HttpStatus.NOT_FOUND);
    }


}
