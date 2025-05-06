package com.bearnrabbit.coffeeorder.domain.customcafe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomCafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ccafe_id", nullable = false)
    private Long ccafeId;

    @Column(name = "ccafe_name", nullable = false)
    private String ccafeName;

    @Column(name = "ccafe_address")
    private String ccafeAddress;
}
