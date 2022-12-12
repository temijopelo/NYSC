package com.example.NYSC.Entity;

import lombok.*;
import org.springframework.context.annotation.ComponentScan;

@Data

public class SavinStudentRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String stateCode;
    private String nameOfPpa;
    private String email;
    private String phoneNumber;
    private String password;
    private String callUpNumber;
    private String serviceYear;
    private String cdsGroup;
    private String cdsDay;
    private String homeAddress;
    private String ppaAddress;
    private String lgAddress;

    public SavinStudentRequest(){

    }


}
