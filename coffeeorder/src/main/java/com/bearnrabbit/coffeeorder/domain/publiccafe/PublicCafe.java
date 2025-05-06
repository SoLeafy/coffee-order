package com.bearnrabbit.coffeeorder.domain.publiccafe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PublicCafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcafe_id", nullable = false)
    private Long pcafeId;

    @Column(name = "pcafe_name", nullable = false)
    private String pcafeName;

    @Column(name = "pcafe_address")
    private String pcafeAddress;
}
