package com.hr.whitus.controllers;

import com.hr.whitus.backend.FibonacciSequence;
import com.hr.whitus.dto.FormDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fibo")
public class FiboController {

    static Map<Map<Integer,String>,Map<Integer,Integer>> allHistory = new HashMap<>();
    @GetMapping
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        mv.addObject("formData", new FormDataDTO(0,10));

        return mv;
    }

    @PostMapping("")
    public ModelAndView getFibonacciSequencesFromLimitToLimit(@ModelAttribute FormDataDTO fiboForm) throws IllegalAccessException
    {
        ModelAndView mv = new ModelAndView("fibo-app/fibo");
        long timeStart = System.currentTimeMillis();//count time start
        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());

        long timePerformance = System.currentTimeMillis() - timeStart;//count time end

        if (validateForm(fiboForm)) {
            List<BigInteger> sequence = FibonacciSequence.printFiboIndexes(start,end);
            recordHistory(start, end);
            mv.addObject("sequence", sequence);
        }
        mv.addObject("time", timePerformance);
        mv.addObject("allHistory", allHistory);
        mv.addObject("formData", new FormDataDTO(start, end));
        return mv;

    }

    @GetMapping("/between-limits")
    public ModelAndView getFibonacciSequencesBetweenLimits(@ModelAttribute FormDataDTO fiboForm) throws IllegalAccessException
    {

        ModelAndView mv = new ModelAndView("fibo-app/fibo");

        long timeStart = System.currentTimeMillis();//count time start
        int start = (fiboForm.getStart());
        int end = (fiboForm.getEnd());

        long timePerformance = System.currentTimeMillis() - timeStart;//count time end

        if (validateForm(fiboForm)){
            List<Integer> sequence = FibonacciSequence.sequenceBetweenLimits(start, end);
            recordHistory(start,end);
            mv.addObject("sequenceBetween",sequence);

        }
        mv.addObject("time", timePerformance);
        mv.addObject("allHistory", allHistory);
        mv.addObject("formData", new FormDataDTO(start,end));
        return mv;

    }

    @GetMapping("value{val}")
    public ModelAndView getFibonacciSequencesBetweenLimits(@RequestParam int val) throws IllegalAccessException
//    public ModelAndView getFibonacciSequencesBetweenLimits(@PathVariable("val") int val) throws IllegalAccessException
    {

        ModelAndView mv = new ModelAndView("fibo-app/fibo");

        long timeStart = System.currentTimeMillis();//count time start


        long timePerformance = System.currentTimeMillis() - timeStart;//count time end

        System.out.println(val);

        BigInteger res = FibonacciSequence.fibonnacci(val);

        mv.addObject("formData", new FormDataDTO(0,10));
        mv.addObject("time", timePerformance);
        mv.addObject("allHistory", allHistory);
        mv.addObject("fiboValue", res);
        return mv;

    }


    private boolean validateForm(FormDataDTO form) {
        return form.getEnd() >= form.getStart();
    }


    private static Map<Integer,Integer> makeHistory(int start, int end){
        Map<Integer,Integer> historyRec = new HashMap<>();
        historyRec.put(start,end);
        return historyRec;
    }

    private static void recordHistory(int start, int end){
        Map<Integer,String> historyRec = new HashMap<>();
        historyRec.put( allHistory.size() + 1 , "index" );
        allHistory.put(historyRec,makeHistory(start,end));
    }

}
