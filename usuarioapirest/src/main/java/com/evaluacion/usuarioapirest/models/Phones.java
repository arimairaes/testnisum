package com.evaluacion.usuarioapirest.models;

import com.evaluacion.usuarioapirest.dtos.PhonesDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phones")
public class Phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String citycode;

    @Column(nullable = false)
    private String contrycode;

    public Phones(PhonesDTO phone) {
        this.id = phone.getId();
        this.number = phone.getNumber();
        this.citycode = phone.getCitycode();
        this.contrycode = phone.getContrycode();
    }
}