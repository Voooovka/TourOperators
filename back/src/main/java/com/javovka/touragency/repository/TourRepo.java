package com.javovka.touragency.repository;

import com.javovka.touragency.model.Tour;
import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepo extends JpaRepository<Tour, Long> {

    Tour findTourById(Long id);


}
