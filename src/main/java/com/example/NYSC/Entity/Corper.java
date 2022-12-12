package com.example.NYSC.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class  Corper {
    @Id
    @SequenceGenerator(
            name = "corper_sequence",
            sequenceName = "corper_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "corper_sequence"
    )


    private Long Id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "State_code")
    private String stateCode;
    @Column(name = "Name_of_ppa")
    private String nameOfPpa;
    @Column(name = "Call_up_number")
    private String callUpNumber;
    @Column(name = "Service_year")
    private String serviceYear;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))


    private Collection<Role> roles;

}