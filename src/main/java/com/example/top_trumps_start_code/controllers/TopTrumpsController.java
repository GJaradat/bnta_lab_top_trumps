package com.example.top_trumps_start_code.controllers;


import com.example.top_trumps_start_code.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/toptrumps")
public class TopTrumpsController {

//    private ArrayList<Card> cards;
    @PostMapping
    public ResponseEntity<Reply> newRound(@RequestBody ArrayList<Card> cards){
        Reply reply = new Reply("");
        return new ResponseEntity<Reply>(reply, HttpStatus.CREATED);
    }


}
