package com.javovka.touragency.service.impl;

import com.javovka.touragency.model.Role;
import com.javovka.touragency.model.Tour;
import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.model.User;
import com.javovka.touragency.repository.TourRepo;
import com.javovka.touragency.repository.UserRepo;
import com.javovka.touragency.service.TourOperatorService;
import com.javovka.touragency.service.TourService;
import com.javovka.touragency.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TourServiceImplTest {

    @Mock
    private TourRepo tourRepo;

    private TourService tourService;

    @BeforeEach
    void setUp(){
        tourService = new TourServiceImpl(tourRepo);
    }

    @Test
    void updateTour() {
        Long id = 1L;

        Tour oldTour = new Tour(1L, "Some Tour", "Cruise", new TourOperator(1L, "Nadia"));
        Tour tour = new Tour(1L, "Some Tour but another", "Cruise but not", new TourOperator(1L, "Nadia but Olya"));

        given(tourRepo.findTourById(id)).willReturn(oldTour);

        tourService.updateTour(id, tour);

        ArgumentCaptor<Tour> argumentCaptor = ArgumentCaptor.forClass(Tour.class);

        Mockito.verify(tourRepo).save(argumentCaptor.capture());

        Tour capturedTour = argumentCaptor.getValue();

        assertThat(capturedTour.getId()).isEqualTo(tour.getId());
        assertThat(capturedTour.getName()).isEqualTo(tour.getName());
        assertThat(capturedTour.getTourType()).isEqualTo(tour.getTourType());
        assertThat(capturedTour.getTourOperator()).isEqualTo(tour.getTourOperator());

    }
}