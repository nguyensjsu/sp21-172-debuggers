package com.example.StarbucksModel;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class PaymentModel {
    private @Id @GeneratedValue Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String cardNumber;
    private String expMonth;
    private String expYear;
    private String cvv;
    private String email;
    
    private String orderNumber;
    private String transactionAmount;
    private String transactionCurrency;
    private String authId;
    private String authStatus;
    private String captureId;
    private String captureStatus;

}