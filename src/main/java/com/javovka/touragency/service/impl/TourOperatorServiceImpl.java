package com.javovka.touragency.service.impl;

import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.model.User;
import com.javovka.touragency.repository.TourOperatorRepo;
import com.javovka.touragency.repository.UserRepo;
import com.javovka.touragency.service.TourOperatorService;
import com.javovka.touragency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TourOperatorServiceImpl implements TourOperatorService {

    private final TourOperatorRepo tourOperatorRepo;

    @Override
    public List<TourOperator> gerTourOperators() {
        return tourOperatorRepo.findAll();
    }

    @Override
    public TourOperator getTourOperator(Long id) {
        return tourOperatorRepo.findTourOperatorById(id);
    }

    @Override
    public TourOperator createTourOperator(TourOperator tourOperator) {
        return tourOperatorRepo.save(tourOperator);
    }

    @Override
    public void deleteTourOperator(Long id) {
        tourOperatorRepo.deleteById(id);
    }

    @Override
    public void updateTourOperator(Long id, TourOperator tourOperator) {
        TourOperator newTourOperator = tourOperatorRepo.findTourOperatorById(id);

        newTourOperator.setName(tourOperator.getName());

        tourOperatorRepo.save(newTourOperator);
    }
}
