package com.example.starbucksgroupproject;

import java.util.Objects;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Column;
import javax.persistence.Table;

import jdk.jfr.DataAmount;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Data
@RequiredArgsConstructor

class StarbucksOrder {

    private @Id @GeneratedValue Long id;

    @Column(nullable=false)     private String drink;
    @Column(nullable=false)     private String size;
    @Column(nullable=false)     private String milk;
    @Column(nullable=false)     private double total;
                                private String status;
}