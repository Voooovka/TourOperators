package com.javovka.touragency.repository;

import com.javovka.touragency.model.TourOperator;
import com.javovka.touragency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourOperatorRepo extends JpaRepository<TourOperator, Long> {

    TourOperator findTourOperatorById(Long id);

}
