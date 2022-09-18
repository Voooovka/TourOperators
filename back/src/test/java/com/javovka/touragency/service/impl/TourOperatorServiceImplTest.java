package com.javovka.touragency.service.impl;

import com.javovka.touragency.model.Tour;
import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.repository.TourOperatorRepo;
import com.javovka.touragency.repository.TourRepo;
import com.javovka.touragency.service.TourOperatorService;
import com.javovka.touragency.service.TourService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TourOperatorServiceImplTest {

    @Mock
    private TourOperatorRepo tourOperatorRepo;

    private TourOperatorService tourOperatorService;

    @BeforeEach
    void setUp(){
        tourOperatorService = new TourOperatorServiceImpl(tourOperatorRepo);
    }

    @Test
    void updateTourOperator() {

        Long id = 1L;

        TourOperator oldTourOperator = new TourOperator(1L, "Nadia Operator");
        TourOperator tourOperator = new TourOperator(1L, "Nadia Operator but not");


        given(tourOperatorRepo.findTourOperatorById(id)).willReturn(oldTourOperator);

        tourOperatorService.updateTourOperator(id, tourOperator);

        ArgumentCaptor<TourOperator> argumentCaptor = ArgumentCaptor.forClass(TourOperator.class);

        Mockito.verify(tourOperatorRepo).save(argumentCaptor.capture());

        TourOperator capturedTour = argumentCaptor.getValue();

        assertThat(capturedTour.getId()).isEqualTo(tourOperator.getId());
        assertThat(capturedTour.getName()).isEqualTo(tourOperator.getName());


    }
}