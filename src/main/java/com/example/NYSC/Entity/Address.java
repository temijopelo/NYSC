package com.example.NYSC.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long addressId;
    @Column(name = "Home_Address")
    private String homeAddress;
    @Column(name = "Ppa_Address")
    private String ppaAddress;
    @Column(name = "Lg_Address")
    private String lgAddress;

    @OneToOne
    @JoinColumn(
            name = "id",
            referencedColumnName = "Id"
    )
    private Corper corper;


}
