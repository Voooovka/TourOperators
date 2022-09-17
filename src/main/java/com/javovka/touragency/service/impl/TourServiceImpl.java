package com.javovka.touragency.service.impl;

import com.javovka.touragency.model.Tour;
import com.javovka.touragency.repository.TourRepo;
import com.javovka.touragency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TourServiceImpl implements TourService {

    private final TourRepo tourRepo;

    @Override
    public List<Tour> gerTours() {
        return tourRepo.findAll();
    }

    @Override
    public Tour getTour(Long id) {
        return tourRepo.findTourById(id);
    }

    @Override
    public Tour createTour(Tour tour) {
        return tourRepo.save(tour);
    }

    @Override
    public void deleteTour(Long id) {
        tourRepo.deleteById(id);
    }

    @Override
    public void updateTour(Long id, Tour tour) {
        Tour newTour = tourRepo.findTourById(id);

        newTour.setName(tour.getName());
        newTour.setTourOperator(tour.getTourOperator());
        newTour.setName(tour.getName());

        tourRepo.save(newTour);

    }
}
