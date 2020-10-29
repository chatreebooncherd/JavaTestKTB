package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class PossibleTotalValRepositoryImpl implements PossibleTotalValRepository {
    @Override
    public List<HashSet<Integer>> possibleTotalVal(HashSet<Integer> inputSet, Integer inputTarget) {

        for(Integer setVal:inputSet){
            if (setVal < 0){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Set is positive integer only.");
            }
        }

        HashSet<Integer> resultSet = new HashSet<Integer>();
        List<HashSet<Integer>> resultList = new ArrayList<HashSet<Integer>>();

        for(Integer setVal:inputSet){
            resultSet = new HashSet<Integer>();
            resultSet.add(setVal);
            Integer totalVal = setVal;
            for(Integer setValSub:inputSet){
                if (totalVal < inputTarget){
                    totalVal += setValSub;
                    resultSet.add(setValSub);
                }
                if (totalVal == inputTarget){
                    resultList.add(resultSet);
                    break;
                }
            }
        }

        return resultList;

    }
}
