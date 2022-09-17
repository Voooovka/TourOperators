package com.javovka.touragency.controller;

import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.model.User;
import com.javovka.touragency.service.TourOperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TourOperatorController {

    private final TourOperatorService tourOperatorService;

    @GetMapping("/tourOperators")
    public List<TourOperator> getAllTourOperators(){
        return tourOperatorService.gerTourOperators();
    }

    @GetMapping("/tourOperators/{id}")
    public TourOperator getTourOperator(@PathVariable Long id){
        return tourOperatorService.getTourOperator(id);
    }

    @PostMapping("/tourOperators")
    public void createTourOperator(@RequestBody TourOperator tourOperator){
        tourOperatorService.createTourOperator(tourOperator);
    }

    @DeleteMapping("/tourOperators/{id}")
    public void deleteTourOperator(@PathVariable Long id){
        tourOperatorService.deleteTourOperator(id);
    }

    @PutMapping("/tourOperators/{id}")
    public void updateTourOperator(@PathVariable Long id, @RequestBody TourOperator tourOperator){
        tourOperatorService.updateTourOperator(id, tourOperator);
    }



}
