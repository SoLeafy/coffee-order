package com.bearnrabbit.coffeeorder.domain.order;

import org.hibernate.annotations.Collate;
import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "join_id")
    private Long joinId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    @Comment("참여자")
    private Long userId;

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "order_opt")
    @Comment("주문 옵션")
    private String orderOpt;
}
