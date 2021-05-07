package com.example.starbucksapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class PaymentsCommand {

    private String action ;

    private String firstName;
    private String lastName;

    
}
