package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    PossibleTotalValRepository possibleTotalValRepository;

    @Mock
    private PossibleTotalValRepository possibleTotalValRepositoryOfMock;

    @Spy
    @InjectMocks
    private PossibleTotalValService helloService = new PossibleTotalValServiceImpl();

    @Test
    public void possibleTotalVal() throws Exception {
        HashSet<Integer> inputSet = new HashSet<Integer>();
        inputSet.add(2);
        inputSet.add(3);
        inputSet.add(5);
        Integer inputTarget = 5;

        List<HashSet<Integer>> resultList = new ArrayList<HashSet<Integer>>();
        HashSet<Integer> inputSetResult = new HashSet<Integer>();
        inputSetResult.add(2);
        inputSetResult.add(3);
        resultList.add(inputSetResult);
        inputSetResult = new HashSet<Integer>();
        inputSetResult.add(5);
        resultList.add(inputSetResult);

        assertEquals(possibleTotalValRepository.possibleTotalVal(inputSet, inputTarget), resultList);

        Mockito.when(possibleTotalValRepositoryOfMock.possibleTotalVal(inputSet, inputTarget)).thenReturn(resultList);

    }

}
