package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class DemoController {

    @Autowired
    PossibleTotalValService possibleTotalValService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/possibleTotalVal")
    public List<HashSet<Integer>> possibleTotalVal(@RequestParam(value = "inputSet") HashSet<Integer> inputSet, @RequestParam(value = "inputTarget") Integer inputTarget) {
        return possibleTotalValService.possibleTotalVal(inputSet, inputTarget);
    }
}