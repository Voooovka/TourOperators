package com.javovka.touragency.service;

import com.javovka.touragency.model.Tour;
import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.model.User;

import java.util.List;

public interface TourOperatorService {

    List<TourOperator> gerTourOperators();
    TourOperator getTourOperator(Long id);
    TourOperator createTourOperator(TourOperator tourOperator);
    void deleteTourOperator(Long id);
    void updateTourOperator(Long id, TourOperator tourOperator);
}
