package com.hr.whitus.controllers.api;


import com.hr.whitus.backend.FibonacciSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/fibo")
public class FiboAPIController {



    @GetMapping("/limit/{start}/{end}")
    public ResponseEntity<List<Integer>> fiboBetweenLimits(@PathVariable("start") int start, @PathVariable("end") int end){

        List<Integer> sequence = FibonacciSequence.sequenceBetweenLimits(start, end);

        return ResponseEntity.ok().body(sequence);  //.ok to return 200
    }

    @GetMapping("/index/{start}/{end}")
    public ResponseEntity<List<BigInteger>> fiboBetweenIndex(@PathVariable("start") int start, @PathVariable("end") int end){

        List<BigInteger> sequence = FibonacciSequence.printFiboIndexes(start, end);

        return ResponseEntity.ok().body(sequence);  //.ok to return 200
    }

    @GetMapping("/{value}")
    public ResponseEntity<BigInteger> findById(@PathVariable("value") int value){

        BigInteger res = FibonacciSequence.fibonnacci(value);

        return ResponseEntity.ok().body(res);  //.ok to return 200
    }
}
