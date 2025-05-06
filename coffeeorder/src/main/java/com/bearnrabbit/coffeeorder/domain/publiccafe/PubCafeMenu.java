package com.bearnrabbit.coffeeorder.domain.publiccafe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PubCafeMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pmenu_id")
    private Long pmenuId;

    @Column(name = "pcafe_id")
    private Long pcafeId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_cost")
    private Integer menuCost;
}
