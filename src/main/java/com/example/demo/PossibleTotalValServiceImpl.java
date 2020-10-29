package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class PossibleTotalValServiceImpl implements PossibleTotalValService {

    @Autowired
    PossibleTotalValRepository possibleTotalValRepository;

    @Override
    public List<HashSet<Integer>> possibleTotalVal(HashSet<Integer> inputSet, Integer inputTarget) {
        return possibleTotalValRepository.possibleTotalVal(inputSet, inputTarget);
    }
}
