package com.bearnrabbit.coffeeorder.domain.customcafe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomCafeMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmenu_id")
    private Long cmenuId;

    @Column(name = "ccafe_id")
    private Long ccafeId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_cost")
    private Integer menuCost;
}
