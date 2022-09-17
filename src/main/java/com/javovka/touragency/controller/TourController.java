package com.javovka.touragency.controller;

import com.javovka.touragency.model.Tour;
import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.service.TourOperatorService;
import com.javovka.touragency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @GetMapping("/tours")
    public List<Tour> getAllTours(){
        return tourService.gerTours();
    }

    @GetMapping("/tours/{id}")
    public Tour getTour(@PathVariable Long id){
        return tourService.getTour(id);
    }

    @PostMapping("/tours")
    public void createTour(@RequestBody Tour tour){
        tourService.createTour(tour);
    }

    @DeleteMapping("/tours/{id}")
    public void deleteTour(@PathVariable Long id){
        tourService.deleteTour(id);
    }

    @PutMapping("/tours/{id}")
    public void updateTour(@PathVariable Long id, @RequestBody Tour tour){
        tourService.updateTour(id, tour);
    }
}
