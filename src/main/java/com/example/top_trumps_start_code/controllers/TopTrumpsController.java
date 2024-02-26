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

    private String round;

    @Autowired
    TopTrumpsService service;
    @PostMapping
    public ResponseEntity<Reply> newRound(@RequestBody ArrayList<Card> cards){
        Reply reply = new Reply(service.checkWinner(cards));
        return new ResponseEntity<Reply>(reply, HttpStatus.CREATED);
    }
    

}
