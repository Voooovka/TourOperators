package com.javovka.touragency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourOperator {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "tourOperator", fetch = FetchType.EAGER)
//    private Set<Tour> tours;

}
