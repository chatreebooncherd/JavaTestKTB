package com.example.demo;

import java.util.HashSet;
import java.util.List;

public interface PossibleTotalValRepository {
    List<HashSet<Integer>> possibleTotalVal(HashSet<Integer> inputSet, Integer inputTarget);
}
