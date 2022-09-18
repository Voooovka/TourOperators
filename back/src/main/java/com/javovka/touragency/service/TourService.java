package com.javovka.touragency.service;

import com.javovka.touragency.model.Tour;
import com.javovka.touragency.model.User;

import java.util.List;

public interface TourService {

    List<Tour> gerTours();
    Tour getTour(Long id);
    Tour createTour(Tour tour);
    void deleteTour(Long id);
    void updateTour(Long id, Tour tour);
}
